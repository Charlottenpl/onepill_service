package com.Medicine.controller;

import com.Medicine.service.MedicineService;
import com.entity.Inquiry;
import com.entity.Medicine;
import com.google.gson.Gson;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/medicine")
public class MedicineController {

    @Resource
    MedicineService medicineService;
    Gson gson = new Gson();

    //查询全部
    @GetMapping("/list")
    public String findAl(){
        return gson.toJson(this.medicineService.findAll());
    }

    //添加
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
    @PostMapping("/findById")
    public String findById(@RequestParam("id")int id){
        return gson.toJson(this.medicineService.findById(id));
    }

    //更新
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
