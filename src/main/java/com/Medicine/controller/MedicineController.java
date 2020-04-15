package com.Medicine.controller;

import com.Medicine.service.MedicineService;
import com.entity.Inquiry;
import com.entity.Medicine;
import com.google.gson.Gson;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Api("药品服务器")
@RestController
@RequestMapping("/medicine")
public class MedicineController {

    @Resource
    MedicineService medicineService;
    Gson gson = new Gson();

    //查询全部
    @ApiOperation("查询全部药品")
    @GetMapping("/list")
    public String findAl(){
        return gson.toJson(this.medicineService.findAll());
    }

    //添加
    @ApiOperation("添加药品")
    @PostMapping("/add")
    public String add(@RequestParam("json") String json){
        try{
            Medicine medicine = gson.fromJson(json,Medicine.class);
            this.medicineService.add(medicine);
            return "yes";
        }catch (Exception e){
            return "no";
        }
    }

    //删除
    @ApiOperation("删除药品")
    @PostMapping("/delete")
    public String add(@RequestParam("id") int id){
        try{
            this.medicineService.delete(id);
            return "yes";
        }catch (Exception e){
            return "no";
        }
    }
    //根据Id查询
    @ApiOperation("根据ID查询药品")
    @PostMapping("/findById")
    public String findById(@RequestParam("id")int id){
        return gson.toJson(this.medicineService.findById(id));
    }

    //更新
    @ApiOperation("更新药品")
    @PostMapping("/update")
    public String update(@RequestParam("json")String json){
        try{
            Medicine medicine = gson.fromJson(json,Medicine.class);
            this.medicineService.add(medicine);
            return "yes";
        }catch (Exception e){
            return "no";
        }
    }
}
