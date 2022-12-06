package com.zhangtory.wallet.core.wallet;

import com.zhangtory.wallet.core.interfaces.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author zhangtory
 * @date 2022/10/6 23:48
 * @description:
 */
@SpringBootTest
@Slf4j
public class CreateAddressTest {

    @Autowired
    private AccountService accountService;


    @Test
    void contextLoads() {
    }

}
