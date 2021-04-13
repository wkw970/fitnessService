package com.atguigu.fit.service;

import com.atguigu.fit.bean.User;


import com.atguigu.fit.config.FileConfig;
import com.atguigu.fit.mapper.UserMapper;
import com.atguigu.fit.utlis.FileTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.rmi.CORBA.Util;
import java.io.IOException;
import java.util.List;

@Service
public class UserService {
    @Autowired
    UserMapper userMapper;
    @Autowired
    FileConfig fileConfig;

    public User getUserByNicknamePassword(String nickname, String password) {
        return userMapper.getUserInfo(nickname, password);
    }


    /**
     * 更新用户信息
     * @param tel
     * @return
     */
    public boolean updateUserInfo(String nickname,String tel) {
        return userMapper.updateUserInfo(nickname,tel);
    }


    /**
     * 更新用户头像
     * @param file
     * @param tel
     * @return
     */
    public boolean updateUserIcon(MultipartFile file,String tel) {
        boolean flag = false;
        //没有图片时
        if (file.isEmpty()) {
            System.out.println("没有文件存在");
        } else {
            String fileName = file.getOriginalFilename();
            fileName = FileTool.renameToUUID(fileName);//生成唯一文件名
            try {
                FileTool.uploadFiles(file.getBytes(), fileConfig.getUploadPath(), fileName);
            } catch (Exception e) {
                e.printStackTrace();
            }
            String url = "/static/" + fileName;
            flag = userMapper.updateUserIcon(url,  tel);
        }
        return flag;
    }

    /**
     * 根据手机号查询用户信息
     * @param tel
     * @return
     */
    public User queryUserByTel(String tel){
        return userMapper.queryIsExistUserByTel(tel);
    }
}
