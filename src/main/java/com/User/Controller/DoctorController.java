package com.User.Controller;

import com.User.service.DoctorService;
import com.entity.Doctor;
import com.entity.Result;
import com.google.gson.Gson;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/doctor")
public class DoctorController {
    Gson gson = null;

    @Resource
    DoctorService doctorService;
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String doctorLogin(@RequestParam(name = "phone") String phone, @RequestParam(name = "password") String password){
        Doctor doctor = doctorService.doctorLogin(phone, password);
        Result result = new Result();
        gson = new Gson();
        if(doctor.getPhone().equals(phone) && doctor.getPassword().equals(password)){
            result.setCode(1);
            result.setDoctor(doctor);
            String str1 = gson.toJson(result);
            System.out.println("医生登录成功！");
            return str1;
        }else if(!doctor.getPhone().equals(phone)){
            result.setCode(2);
            result.setDoctor(doctor);
            String str2 = gson.toJson(result);
            System.out.println("医生登录失败,电话错误！");
        return str2;
    }else if(!doctor.getPassword().equals(password)){
        result.setCode(3);
        result.setDoctor(doctor);
        String str3 = gson.toJson(result);
        System.out.println("医生登录失败,密码错误！");
        return str3;
    }
        return null;
    }
}
