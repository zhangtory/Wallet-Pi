package com.zhangtory.wallet.core.model.vo.signature;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author zhangtory
 * @date 2022/10/6 0:00
 * @description:
 */
@Data
public class SignParams {

    private String fromAddress;

    private String signerAddress;

    private String toAddress;

    private BigDecimal amount;

    private String contract;

}
