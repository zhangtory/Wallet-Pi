package com.zhangtory.wallet.core.service;

import com.zhangtory.wallet.core.interfaces.AccountService;
import com.zhangtory.wallet.core.interfaces.WalletService;
import com.zhangtory.wallet.core.interfaces.signature.Signer;
import com.zhangtory.wallet.core.model.entity.Address;
import com.zhangtory.wallet.core.model.request.AddressQueryRequest;
import com.zhangtory.wallet.core.model.request.CreateAddressRequest;
import lombok.extern.slf4j.Slf4j;
import org.bitcoinj.crypto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zhangtory
 * @date 2022/10/6 23:51
 * @description:
 */
@Service
@Slf4j
public class AccountServiceImpl implements AccountService {

    @Autowired
    private WalletService walletService;

    @Autowired
    private Signer signer;

    /**
     * 获取地址
     *
     * @return
     */
    @Override
    public Address createAddress(CreateAddressRequest request) {
        byte[] seed = walletService.getSeed(request.getWalletId(), request.getPassphrase());
        DeterministicKey masterKey = HDKeyDerivation.createMasterPrivateKey(seed);
        DeterministicHierarchy masterDH = new DeterministicHierarchy(masterKey);
        List<ChildNumber> parentPath = HDPath.parsePath(signer.getParentPath());
        DeterministicKey deterministicKey = masterDH.get(parentPath, false, true);
        return signer.createAccount(deterministicKey.getPrivKeyBytes());
    }

    /**
     * 地址列表查询
     *
     * @param request
     * @return
     */
    @Override
    public List<Address> queryAddress(AddressQueryRequest request) {
        return null;
    }
}
