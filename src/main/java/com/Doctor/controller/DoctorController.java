package com.Doctor.controller;


import com.Doctor.Dao.DoctorRepository;
import com.entity.Comment;
import com.entity.Doctor;
import com.google.gson.Gson;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.print.Doc;

@RestController
@RequestMapping("/doctor")
@Api("医生服务器")
public class DoctorController {

    @Resource
    DoctorRepository doctorRepository;
    Gson gson = new Gson();


    //添加医生
    @ApiOperation("增加医生")
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public String add(@RequestParam("json")String json){
        try{
            Doctor doctor = gson.fromJson(json, Doctor.class);
            this.doctorRepository.save(doctor);
            return "yes";
        }catch (Exception e){
            return "no";
        }
    }

    //根据ID删除医生
    @ApiOperation("根据ID删除医生")
    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    public String delete(@RequestParam("id")int id){
        try{
            this.doctorRepository.deleteById(id);
            return "yes";
        }catch (Exception e){
            return "no";
        }
    }

    //查询所有医生
    @ApiOperation("查询所有医生")
    @RequestMapping(value = "/doctor",method = RequestMethod.POST)
    public String list(){
        return gson.toJson(this.doctorRepository.findAll());
    }

    //根据Id查询医生
    @ApiOperation("根据Id查询医生")
    @RequestMapping(value = "/findById",method = RequestMethod.GET)
    public String findById(@RequestParam("id")int id){
        return gson.toJson(this.doctorRepository.findById(id));
    }

    //更新医生信息
    @ApiOperation("更新医生信息")
    @PostMapping(value = "/update")
    public String update(@RequestParam("id")int id,@RequestParam("code")String code,@RequestParam("str")String str){
        try{
            //获取Id
            Doctor doctor = this.doctorRepository.findById(id);
            switch (code){
                case "name":
                    doctor.setName(str);
                    break;
                case "phonne":
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
            this.doctorRepository.save(doctor);
            return "yes";
        }catch (Exception e){
            return "no";
        }
    }

    //根据Name查询医生
    @ApiOperation("更新医生信息")
    @GetMapping(value = "/findByName")
    public String findByName(@RequestParam("name")String name){
        return gson.toJson(this.doctorRepository.findByName(name));
    }
}
