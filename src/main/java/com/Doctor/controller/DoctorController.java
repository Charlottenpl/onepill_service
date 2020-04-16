package com.Doctor.controller;


import com.Doctor.service.DoctorService;
import com.entity.Doctor;
import com.entity.Result;
import com.google.gson.Gson;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/doctor")
@Api("医生服务器")
public class DoctorController {

    @Resource
    private DoctorService doctorService;
    Gson gson = null;

    //医生登录
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

    //添加医生
    @ApiOperation("增加医生")
    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public String add(@RequestParam("json")String json){
        gson = new Gson();
        Doctor doctor = gson.fromJson(json, Doctor.class);
        boolean isSuccessful = this.doctorService.add(doctor);
        if (isSuccessful) {
            String result = gson.toJson(true);
            return result;
        } else {
            String result = gson.toJson(false);
            return result;
        }
    }

    //根据ID删除医生
    @ApiOperation("根据ID删除医生")
    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    public String delete(@RequestParam("id")int id){
        try{
            this.doctorService.delete(id);
            return "yes";
        }catch (Exception e){
            return "no";
        }
    }

    //查询所有医生
    @ApiOperation("查询所有医生")
    @RequestMapping(value = "/doctor",method = RequestMethod.POST)
    public String list(){
        return gson.toJson(this.doctorService.findAllDoctor());
    }

    //根据Id查询医生
    @ApiOperation("根据Id查询医生")
    @RequestMapping(value = "/findById",method = RequestMethod.GET)
    public String findById(@RequestParam("id")int id){
        return gson.toJson(this.doctorService.findById(id));
    }

    //更新医生信息
    @ApiOperation("更新医生信息")
    @PostMapping(value = "/update")
    public String update(@RequestParam("id")int id,@RequestParam("code")String code,@RequestParam("str")String str){
        try{
            //获取Id
            Doctor doctor = this.doctorService.findById(id);
            switch (code){
                case "name":
                    doctor.setName(str);
                    break;
                case "phone":
                    doctor.setPhone(str);
                    break;
                case "address":
                    doctor.setAddress(str);
                    break;
                case "password":
                    doctor.setPassword(str);
                    break;
                case "PID":
                    doctor.setPID(str);
                    break;
                case "hospital":
                    doctor.setHospital(str);
                    break;
                case "headImg":
                    doctor.setHeadImg(str);
                    break;
                case "tag":
                    doctor.setTag(str);
                    break;
                case "resume":
                    doctor.setResume(str);
                    break;
            }
            this.doctorService.add(doctor);
            return "yes";
        }catch (Exception e){
            return "no";
        }
    }

    //根据Name查询医生
    @ApiOperation("更新医生信息")
    @GetMapping(value = "/findByName")
    public String findByName(@RequestParam("name")String name){
        return gson.toJson(this.doctorService.findByName(name));
    }
}
