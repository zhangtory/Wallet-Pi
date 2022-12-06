package com.zhangtory.eth.signer;

import com.zhangtory.wallet.core.interfaces.signature.Signer;
import com.zhangtory.wallet.core.model.entity.Address;
import com.zhangtory.wallet.core.model.vo.signature.SignParams;
import com.zhangtory.wallet.core.model.vo.signature.SignedData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.web3j.crypto.ECKeyPair;

/**
 * @author zhangtory
 * @date 2022/10/7 20:45
 * @description:
 */
@Service
@Slf4j
public class EthSigner implements Signer {

    private static final String PARENT_PATH = "m/44'/60'/0'/0";

    /**
     * 创建一个新的账户
     *
     * @param seed
     * @return address
     */
    @Override
    public Address createAccount(byte[] seed) {
        ECKeyPair ecKeyPair = ECKeyPair.create(seed);


        return null;
    }

    /**
     * 交易签名
     *
     * @param signParams
     * @return
     */
    @Override
    public SignedData sign(SignParams signParams) {
        return null;
    }

    /**
     * 获取bip44 path
     *
     * @return
     */
    @Override
    public String getParentPath() {
        return PARENT_PATH;
    }

}
