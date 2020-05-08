package com.Restapi.Controller;


import com.Restapi.Service.AuthService;
import com.google.gson.Gson;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Resource
    AuthService authService;
    Gson gson = new Gson();

    //获取Token
    @RequestMapping(value = "/getToken",method = RequestMethod.GET)
    public String getToken(){
        return authService.getAuth();
    }

    //注册用户
    @RequestMapping(value = "/register",method = RequestMethod.GET)
    public String register(@RequestParam(name = "userName") String userName,
                           @RequestParam(name = "password") String password,
                           @RequestParam(name = "nickName") String nickName){
        return authService.Register(userName,password,nickName);
    }

}
