package com.zhangtory.wallet.core.controller;

import com.zhangtory.wallet.core.interfaces.WalletService;
import com.zhangtory.wallet.core.model.request.WalletCheckRequest;
import com.zhangtory.wallet.core.model.response.WalletInitResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author zhangtory
 * @date 2022/10/7 14:50
 * @description:
 */
@RequestMapping("wallet")
@RestController
@Slf4j
public class WalletController {

    @Autowired
    private WalletService walletService;

    @GetMapping("init")
    public WalletInitResponse initWallet() {
        return walletService.generateBip39Mnemonics();
    }

    @PostMapping("check")
    public boolean checkMnemonic(WalletCheckRequest request) {
        return walletService.checkMnemonics(request);
    }

    @PostMapping("recover")
    public boolean recover(List<String> words) {
        return walletService.recover(words);
    }

}
