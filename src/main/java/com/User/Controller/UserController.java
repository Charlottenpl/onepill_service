package com.User.Controller;

import com.User.service.UserService;
import com.entity.Result;
import com.entity.User;
import com.google.gson.Gson;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/user")
@Api( value = "用户服务器")
public class UserController {

    @Resource
    private UserService userService;
    Gson gson = new Gson();

    @ApiOperation("用户登陆")
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String userLogin(@RequestParam (name = "phone") String phone,@RequestParam(name = "password") String password){
        System.out.println("开始登陆");
        User user = userService.userLogin(phone, password);
        Result result = new Result();
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


    @ApiOperation("添加用户")
    @PostMapping("/add")
    public String add(@RequestParam("json") String json){
        try{
            this.userService.save(gson.fromJson(json,User.class));
            return "yes";
        }catch (Exception e){
            return "no";
        }

    }

    @ApiOperation("删除用户")
    @GetMapping("/delete")
    public String delete(@RequestParam("id")int id){
        try{
            this.userService.delete(id);
            return "yes";
        }catch (Exception e){
            return "no";
        }
    }


    @ApiOperation("更新用户信息")
    @PostMapping("/update")
    public String update(@RequestParam("json")String json){
        try{
            this.userService.save(gson.fromJson(json,User.class));
            return "yes";
        }catch (Exception e){
            return "no";
        }
    }


    @ApiOperation("根据Id查询用户")
    @GetMapping("/findById")
    public String findById(@RequestParam("id")int id){
        return gson.toJson(this.userService.findById(id));
    }
}
