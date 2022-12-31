package com.zhangtory.wallet.core.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zhangtory.wallet.core.model.entity.Wallet;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author zhangtory
 * @date 2022/10/7 0:13
 * @description:
 */
@Mapper
public interface WalletMapper extends BaseMapper<Wallet> {
}
