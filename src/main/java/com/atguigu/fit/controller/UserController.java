package com.atguigu.fit.controller;


import com.atguigu.fit.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.atguigu.fit.bean.User;
import org.springframework.web.multipart.MultipartFile;


import java.util.List;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @ResponseBody
    @GetMapping("/get_userInfo")
    public User getUserByNicknamePassword(@RequestParam("user")String user,@RequestParam("password")String password)
    {
        User user1=userService.getUserByNicknamePassword(user,password);
        //如果为空说明没有user
        if (user1==null)
        {
            user1 = new User();
            user1.setNickname("nnn");
            return user1;
        }
        else
        {
            System.out.println(user1.getNickname()+"登录成功");
            return user1;
        }

    }

    @ResponseBody
    @GetMapping("/get_queryByTel")
    public User queryByTel(@RequestParam("tel") String tel){
        User user = userService.queryUserByTel(tel);
        User newUser = new User();
        //意思是根据手机号并没有查到用户信息
        if (user ==null){
            newUser.setNickname("nnn");
            return newUser;
        }else {
            return user;
        }
    }


    /**
     * 更新用户昵称
     * @param nickname
     * @param tel
     * @return
     */
    @ResponseBody
    @PostMapping("post_update_userInfo")
    public boolean updateUserInfo(@RequestParam("nickname")String nickname,@RequestParam("tel")String tel){
        System.out.println("用户信息更新成功！");
       return userService.updateUserInfo(nickname,tel);
    }

    /**
     * 根据用户手机号更新icon
     * @param file
     * @param tel
     * @return
     */
    @ResponseBody
    @PostMapping("post_update_icon")
    public boolean updateUserIcon(@RequestParam("file")MultipartFile file,@RequestParam("tel")String tel)
    {
        return userService.updateUserIcon(file,tel);
    }

}
