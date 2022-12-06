package com.zhangtory.wallet.core.model.request;

import lombok.Data;

import java.util.List;

/**
 * @author zhangtory
 * @date 2022/12/6 21:34
 * @description:
 */
@Data
public class WalletCheckRequest {

    private Integer walletId;

    private List<MnemonicPair> mnemonicPairList;

    @Data
    public static class MnemonicPair {
        public Integer index;
        public String word;
    }

}
