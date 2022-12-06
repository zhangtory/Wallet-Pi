package com.zhangtory.wallet.core.controller;

import com.zhangtory.wallet.core.interfaces.AccountService;
import com.zhangtory.wallet.core.model.entity.Address;
import com.zhangtory.wallet.core.model.request.AddressQueryRequest;
import com.zhangtory.wallet.core.model.request.CreateAddressRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author zhangtory
 * @date 2022/10/6 21:04
 * @description:
 */
@RequestMapping("account")
@RestController
@Slf4j
public class AccountController {

    @Autowired
    private AccountService accountService;

    @GetMapping("create")
    public Address createAddress(CreateAddressRequest request) {
        return accountService.createAddress(request);
    }

    @GetMapping("query")
    public List<Address> queryAddress(AddressQueryRequest request) {
        return accountService.queryAddress(request);
    }

}
