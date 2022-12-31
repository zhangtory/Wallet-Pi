package com.zhangtory.wallet.core.model.entity;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author zhangtory
 * @date 2022/10/7 0:11
 * @description:
 */
@Data
@Builder
public class Wallet {

    private Integer id;

    private String mnemonics;

    private LocalDateTime createTime;

}
