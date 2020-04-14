package com.Inquiry.controller;

import com.Inquiry.service.InquiryService;
import com.entity.Focus;
import com.entity.Inquiry;
import com.google.gson.Gson;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping(value = "/inquiry")
public class InquiryController {

    @Resource
    InquiryService inquiryService;
    Gson gson = new Gson();

    //查询全部
    @GetMapping("/list")
    public String list(){
       return gson.toJson(this.inquiryService.findAll());
    }

    //添加
    @PostMapping("/add")
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
    @PostMapping("/findById")
    public String findById(@RequestParam("id")int id){
        return gson.toJson(this.inquiryService.findById(id));
    }
    //根据UserId查询
    @PostMapping("/findByUserId")
    public String findByUserId(@RequestParam("userId")int userId){
        return gson.toJson(this.inquiryService.findById(userId));
    }
}
