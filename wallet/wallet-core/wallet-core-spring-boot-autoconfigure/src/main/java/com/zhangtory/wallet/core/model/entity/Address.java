package com.zhangtory.wallet.core.model.entity;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author zhangtory
 * @date 2022/10/7 19:53
 * @description:
 */
@Data
@Builder
public class Address {

    private Integer id;

    private String address;

    private String publicKey;

    private LocalDateTime createTime;

}
