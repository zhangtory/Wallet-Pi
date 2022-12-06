package com.zhangtory.wallet.core.model.vo.signature;

import lombok.Data;

/**
 * @author zhangtory
 * @date 2022/10/5 23:55
 * @description:
 */
@Data
public class SignedData {

    private String txHash;

    private String rawData;

}
