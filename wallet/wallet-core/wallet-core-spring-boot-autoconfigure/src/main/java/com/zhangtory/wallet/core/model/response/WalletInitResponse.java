package com.zhangtory.wallet.core.model.response;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author zhangtory
 * @date 2022/12/6 21:18
 * @description:
 */
@Data
public class WalletInitResponse {

    /**
     * wallet id
     */
    private Integer id;

    /**
     * mnemonics
     */
    private List<String> mnemonics;

    /**
     * createTime
     */
    private LocalDateTime createTime;

}
