package com.Focus.controller;

import com.Focus.service.FocusService;
import com.entity.Doctor;
import com.entity.Focus;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.lang.reflect.Type;
import java.util.ArrayList;

@RestController
@RequestMapping("/focus")
public class FocusController {

    @Resource
    FocusService focusService;
    Gson gson = new Gson();

    //获取收藏医生列表
    @RequestMapping(value = "/doctorList")
    public String findDoctor(@RequestParam("userId") int userId,@RequestParam("userType") int userType){
        return gson.toJson(this.focusService.findDoctorList(userId,userType));
    }

    //获取收藏药品列表
    @RequestMapping(value = "/medicineList")
    public String findMedicine(@RequestParam("userId") int userId,@RequestParam("userType") int userType){
        return gson.toJson(this.focusService.findMedicine(userId,userType));
    }

    //取消收藏
    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    public String delete(@RequestParam("userId") int userId,@RequestParam("userType") int userType,@RequestParam("type") int type,@RequestParam("typeId") int typeId){
        try{
            this.focusService.delete(userId,userType,type,typeId);
            return "yes";
        }catch (Exception e){
            return "no";
        }
    }


    //新增收藏
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public String delete(@RequestParam("json") String json){
        try{
            Focus focus = gson.fromJson(json,Focus.class);
            this.focusService.save(focus);
            return "yes";
        }catch (Exception e){
            return "no";
        }
    }


    //isHave
    public String isHave(int userId,int userType,int type,int typeId){
        try{
            this.focusService.isHave(userId,userType,type,typeId);
            return "yes";
        }catch (Exception e){
            return "no";
        }
    }
}
