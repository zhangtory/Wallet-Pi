package com.zhangtory.wallet.core.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zhangtory.wallet.core.model.entity.Address;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author zhangtory
 * @date 2022/10/7 20:02
 * @description:
 */
@Mapper
public interface AddressMapper extends BaseMapper<Address> {
}
