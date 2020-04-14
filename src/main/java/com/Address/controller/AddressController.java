// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   AddressController.java

package com.Address.controller;

import com.entity.Address;
import com.google.gson.Gson;
import com.Address.service.AddressService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;
import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/address")
public class AddressController {

    Gson gson = new Gson();
    @Resource
    AddressService addressService;


    //查询所有地址
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public String list()
    {
        java.util.List addressList = addressService.listAll();
        String result = gson.toJson(addressList);
        return result;
    }

    //添加地址
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public String add(@RequestParam("json") String json)
    {
        try{
            Address address = gson.fromJson(json, Address.class);
            addressService.saveAddress(address);
            return "yes";
        }catch(Exception e){
            return "no";
        }
    }

    //更新地址
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public String update(@RequestParam("json") String json)
    {
        try{
            Address address = gson.fromJson(json, Address.class);
            addressService.saveAddress(address);
            return "yes";
        }catch (Exception e){
            return "no";
        }
    }

    //删除地址
    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    public String delete(@RequestParam("id") int id)
    {

        try{
            addressService.delAddress(id);
            return "yes";
        }catch (Exception e){
            return "no";
        }
    }

    //根据UserId查询地址
    @RequestMapping(value = "findByUserId",method = RequestMethod.GET)
    public List<Address> findAddressByUserId(@RequestParam("userId") int userId){
        return this.addressService.findByUserId(userId);
    }

}

