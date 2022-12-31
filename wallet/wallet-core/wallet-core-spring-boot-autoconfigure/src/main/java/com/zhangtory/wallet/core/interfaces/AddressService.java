package com.zhangtory.wallet.core.interfaces;

import com.zhangtory.wallet.core.model.entity.Address;
import com.zhangtory.wallet.core.model.request.AddressQueryRequest;
import com.zhangtory.wallet.core.model.request.CreateAddressRequest;

import java.util.List;

/**
 * @author zhangtory
 * @date 2022/10/6 23:48
 * @description:
 */
public interface AddressService {

    /**
     * 创建地址
     * @return
     */
    Address createAddress(CreateAddressRequest request);

    /**
     * 地址列表查询
     * @param request
     * @return
     */
    List<Address> queryAddress(AddressQueryRequest request);

}
