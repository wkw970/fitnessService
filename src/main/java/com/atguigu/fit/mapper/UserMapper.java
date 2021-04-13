package com.atguigu.fit.mapper;


import com.atguigu.fit.bean.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface UserMapper {

    /**
     * 获取用户信息
     * @param user
     * @param password
     * @return
     */
    public User getUserInfo(String user, String password);

    /**
     * 根据用户手机号查询用户信息
     * @param tel
     * @return
     */
    public User queryIsExistUserByTel(String tel);


    /**
     * 更新用户昵称
     * @param nickname tel
     * @return
     */
    public boolean updateUserInfo(String nickname,String tel);

    /**
     * 更新用户头像
     * @param url
     * @param tel
     * @return
     */
    public boolean updateUserIcon(String url,String tel);
}
