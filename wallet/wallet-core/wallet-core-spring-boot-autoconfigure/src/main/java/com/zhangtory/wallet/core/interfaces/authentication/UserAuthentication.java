package com.zhangtory.wallet.core.interfaces.authentication;


import com.zhangtory.wallet.core.model.vo.authentication.UserOperateDate;

/**
 * @author zhangtory
 * @date 2022/10/6 0:09
 * @description: 用户鉴权
 */
public interface UserAuthentication {

    /**
     * 用户操作鉴权
     * @param userOperateDate
     * @return
     */
    boolean userOperation(UserOperateDate userOperateDate);

}
