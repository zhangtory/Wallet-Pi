package com.zhangtory.wallet.core.interfaces;

import com.zhangtory.wallet.core.model.request.WalletCheckRequest;
import com.zhangtory.wallet.core.model.response.WalletInitResponse;

import java.util.List;

/**
 * @author zhangtory
 * @date 2022/10/6 21:30
 * @description:
 */
public interface WalletService {

    /**
     * 通过安全随机数生成满足BIP39协议的助记词
     * @return
     */
    WalletInitResponse generateBip39Mnemonics();

    /**
     * 校验助记词是否为生成的私钥
     * @param request
     * @return
     */
    boolean checkMnemonics(WalletCheckRequest request);

    /**
     * 获取私钥seed
     * @param walletId
     * @param passphrase
     * @return
     */
    byte[] getSeed(Integer walletId, String passphrase);

    /**
     * 还原私钥
     * @param mnemonics
     * @return
     */
    boolean recover(List<String> mnemonics);

}
