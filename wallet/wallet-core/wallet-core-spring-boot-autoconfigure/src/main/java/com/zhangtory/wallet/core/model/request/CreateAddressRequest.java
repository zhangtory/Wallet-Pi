package com.zhangtory.wallet.core.model.request;

import lombok.Data;

/**
 * @author zhangtory
 * @date 2022/10/7 19:50
 * @description:
 */
@Data
public class CreateAddressRequest {

    private Integer walletId;

    private String passphrase;

}
