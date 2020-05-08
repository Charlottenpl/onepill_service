package com.Focus.controller;

import com.Doctor.service.DoctorService;
import com.Focus.service.FocusService;
import com.Medicine.service.MedicineService;
import com.entity.Doctor;
import com.entity.Focus;
import com.entity.Medicine;
import com.entity.ToFocus;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import javafx.geometry.Pos;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.print.Doc;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/focus")
@Api("关注与收藏服务器")
public class FocusController {

    @Resource
    FocusService focusService;
    @Resource
    DoctorService doctorService;
    @Resource
    MedicineService medicineService;
    Gson gson = new Gson();

    //获取收藏医生列表
    @ApiOperation("获取关注医生的列表")
    @RequestMapping(value = "/doctorList",method = RequestMethod.GET)
    public String findDoctor(@RequestParam("userId") int userId,@RequestParam("userType") int userType){
        List<Focus> focusList =  this.focusService.findDoctorList(userId,userType);
        List<ToFocus> toFocusList = new ArrayList<>();
        Doctor doctor = null;
        for (Focus f : focusList){
            doctor = doctorService.findById(f.getTypeId());
            ToFocus toFocus = new ToFocus();
            toFocus.setId(f.getId());
            toFocus.setImg(doctor.getHeadImg());
            toFocus.setMore(doctor.getResume());
            toFocus.setName(doctor.getName());
            toFocus.setType(f.getType());
            toFocus.setTypeId(f.getTypeId());
            toFocus.setUserId(f.getUserId());
            toFocus.setUserType(f.getUserType());
            toFocusList.add(toFocus);
        }
        return gson.toJson(toFocusList);
    }

    //获取收藏药品列表
    @ApiOperation("获取收藏药品的列表")
        @RequestMapping(value = "/medicineList",method = RequestMethod.GET)
    public String findMedicine(@RequestParam("userId") int userId,@RequestParam("userType") int userType){
        List<Focus> focusList =  this.focusService.findMedicine(userId,userType);
        List<ToFocus> toFocusList = new ArrayList<>();
        Medicine medicine = null;
        for (Focus f : focusList){
            medicine = medicineService.findById(f.getTypeId());
            ToFocus toFocus = new ToFocus();
            toFocus.setId(f.getId());
            toFocus.setImg(medicine.getImg1());
            toFocus.setMore(medicine.getMedicine());
            toFocus.setName(medicine.getGeneralName());
            toFocus.setType(f.getType());
            toFocus.setTypeId(f.getTypeId());
            toFocus.setUserId(f.getUserId());
            toFocus.setUserType(f.getUserType());
            toFocusList.add(toFocus);
        }
        return gson.toJson(toFocusList);
    }

    //取消收藏
    @ApiOperation("取消收藏")
    @RequestMapping(value = "/delete",method = RequestMethod.GET)
    public String delete(@RequestParam("userId") int userId,@RequestParam("userType") int userType,@RequestParam("type") int type,@RequestParam("typeId") int typeId){
        try{
            System.out.println("!!!!!!"+userId+userType+type+typeId);
            this.focusService.delete(userId,userType,type,typeId);
            return "yes";
        }catch (Exception e){
            return "no";
        }
    }

    //新增收藏
    @ApiOperation("新增收藏")
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
    @GetMapping("/isHave")
    @ApiOperation("查询是否收藏")
    public String isHave(@RequestParam("userId") int userId,@RequestParam("userType") int userType,@RequestParam("type") int type,@RequestParam("typeId") int typeId){

        if (this.focusService.isHave(userId,userType,type,typeId)) {
            return "yes";
        } else {
            return "no";
        }

    }
}
