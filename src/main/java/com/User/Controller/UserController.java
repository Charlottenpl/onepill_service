package com.User.Controller;

import com.User.service.UserService;
import com.entity.Result;
import com.entity.User;
import com.google.gson.Gson;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/user")
@Api( value = "用户服务器")
public class UserController {
    Gson gson = null;

    @Resource
    private UserService userService;

    @ApiOperation("用户登陆")
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String userLogin(@RequestParam (name = "phone") String phone,@RequestParam(name = "password") String password){
        System.out.println("开始登陆");
        User user = userService.userLogin(phone, password);
        Result result = new Result();
        gson = new Gson();
        if(user.getPhone().equals(phone) && user.getPassword().equals(password)){
            result.setCode(1);
            result.setUser(user);
            String str1 = gson.toJson(result);
            System.out.println("病人登录成功！");
           return str1;
        }else if(!user.getPhone().equals(phone)){
            result.setCode(2);
            result.setUser(user);
            String str2 = gson.toJson(result);
            System.out.println("病人登录失败,电话错误！");
            return str2;
        }else if(!user.getPassword().equals(password)){
            result.setCode(3);
            result.setUser(user);
            String str3 = gson.toJson(result);
            System.out.println("病人登录失败,密码错误！");
            return str3;
        }
        return null;
    }
}
