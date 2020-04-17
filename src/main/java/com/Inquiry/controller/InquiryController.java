package com.Inquiry.controller;

import com.Inquiry.service.InquiryService;
import com.entity.Focus;
import com.entity.Inquiry;
import com.google.gson.Gson;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping(value = "/inquiry")
@Api("问诊记录服务器")
public class InquiryController {

    @Resource
    InquiryService inquiryService;
    Gson gson = new Gson();

    //查询全部
    @GetMapping("/list")
    @ApiOperation("查询所有问诊记录")
    public String list(){
       return gson.toJson(this.inquiryService.findAll());
    }

    //添加
    @PostMapping("/add")
    @ApiOperation("添加问诊记录")
    public String add(@RequestParam("json")String json){
        try{
            Inquiry inquiry = gson.fromJson(json,Inquiry.class);
            this.inquiryService.add(inquiry);
            return "yes";
        }catch (Exception e){
            return "no";
        }
    }

    //删除
    @ApiOperation("删除问诊记录")
    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    public String delete(@RequestParam("id") int id){
        try{
            this.inquiryService.delete(id);
            return "yes";
        }catch (Exception e){
            return "no";
        }
    }

    //根据Id查询
    @ApiOperation("根据ID查询问诊记录")
    @PostMapping("/findById")
    public String findById(@RequestParam("id")int id){
        return gson.toJson(this.inquiryService.findById(id));
    }

    //根据UserId查询
    @GetMapping("/findByUserId")
    @ApiOperation("根据userId查询问诊记录")
    public String findByUserId(@RequestParam("userId")int userId){
        return gson.toJson(this.inquiryService.findById(userId));
    }
}
