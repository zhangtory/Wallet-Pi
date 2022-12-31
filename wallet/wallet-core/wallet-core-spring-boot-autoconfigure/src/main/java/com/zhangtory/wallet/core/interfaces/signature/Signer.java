package com.zhangtory.wallet.core.interfaces.signature;

import com.zhangtory.wallet.core.model.entity.Address;
import com.zhangtory.wallet.core.model.vo.signature.SignParams;
import com.zhangtory.wallet.core.model.vo.signature.SignedData;

/**
 * @author zhangtory
 * @date 2022/10/5 21:40
 * @description: the interface of offline sign
 */
public interface Signer {

    /**
     * 创建一个新的账户
     * @return address
     */
    Address createAddress(byte[] seed);

    /**
     * 交易签名
     * @param signParams
     * @return
     */
    SignedData sign(SignParams signParams);

    /**
     * 获取bip44 path
     * @return
     */
    String getParentPath();

}
