package com.zhangtory.wallet.core.service;

import com.zhangtory.wallet.core.interfaces.WalletService;
import com.zhangtory.wallet.core.mapper.WalletMapper;
import com.zhangtory.wallet.core.model.entity.Wallet;
import com.zhangtory.wallet.core.model.request.WalletCheckRequest;
import com.zhangtory.wallet.core.model.response.WalletInitResponse;
import lombok.extern.slf4j.Slf4j;
import org.bitcoinj.core.ECKey;
import org.bitcoinj.crypto.MnemonicCode;
import org.bitcoinj.crypto.MnemonicException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * @author zhangtory
 * @date 2022/10/6 21:30
 * @description:
 */
@Service
@Slf4j
public class WalletServiceImpl implements WalletService {

    @Autowired
    private WalletMapper walletMapper;

    /**
     * 通过安全随机数生成满足BIP39协议的助记词
     *
     * @return
     */
    @Override
    public WalletInitResponse generateBip39Mnemonics() {
        WalletInitResponse wallet = new WalletInitResponse();
        try {
            ECKey ecKey = new ECKey();
            byte[] privateKeyBytes = ecKey.getPrivKeyBytes();
            MnemonicCode mnemonicCode = new MnemonicCode();
            List<String> mnemonics = mnemonicCode.toMnemonic(privateKeyBytes);
            Wallet insert = Wallet.builder().mnemonics(String.join(",", mnemonics)).build();
            walletMapper.insert(insert);
            wallet.setMnemonics(mnemonics);
            wallet.setId(insert.getId());
            wallet.setCreateTime(insert.getCreateTime());
        } catch (IOException | MnemonicException.MnemonicLengthException e) {
            log.error("generate BIP39 mnemonics error.", e);
        }
        return wallet;
    }

    /**
     * 校验助记词是否为生成的助记词
     * @return
     */
    @Override
    public boolean checkMnemonics(WalletCheckRequest request) {
        Wallet mnemonics = walletMapper.selectById(request.getWalletId());
        String[] mnemonicArray = mnemonics.getMnemonics().split(",");
        return request.getMnemonicPairList().stream()
                .map(pair -> mnemonicArray[pair.getIndex()].equals(pair.getWord()))
                .reduce(true, (a, b) -> a && b);
    }

    /**
     * 获取私钥seed
     *
     * @param walletId
     * @param passphrase
     * @return
     */
    @Override
    public byte[] getSeed(Integer walletId, String passphrase) {
        Wallet wallet = walletMapper.selectById(walletId);
        if (wallet == null) {
            throw new RuntimeException("no such mnemonic");
        }
        return MnemonicCode.toSeed(Arrays.asList(wallet.getMnemonics().split(",")), passphrase);
    }

    /**
     * 还原私钥
     *
     * @param mnemonics
     */
    @Override
    public boolean recover(List<String> mnemonics) {
        try {
            MnemonicCode mnemonicCode = new MnemonicCode();
            mnemonicCode.check(mnemonics);
            walletMapper.insert(Wallet.builder().mnemonics(String.join(",", mnemonics)).build());
            return true;
        } catch (IOException | MnemonicException e) {
            log.error("check mnemonics error.", e);
        }
        // TODO 如果已经存在，则返回信息
        return false;
    }

}
