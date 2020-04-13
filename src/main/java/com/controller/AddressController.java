// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   AddressController.java

package com.controller;

import com.entity.Address;
import com.google.gson.Gson;
import com.service.AddressService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;

@RestController
@RequestMapping("/address")
public class AddressController {

    Gson gson = new Gson();
    @Resource
    AddressService addressService;


    @RequestMapping(value = "/list")
    public String list()
    {
        System.out.println("获取所有地址信息：");
        java.util.List addressList = addressService.listAll();
        String result = gson.toJson(addressList);
        return result;
    }

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public String add(@RequestParam("json") String json)
    {
        Address address = gson.fromJson(json, Address.class);
        addressService.saveAddress(address);
        if(addressService.isExist(address.getId())) {
            return "yes";
        } else {
            return "no";
        }
    }

    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public String update(@RequestParam("json") String json)
    {
        Address address = gson.fromJson(json, Address.class);
        String f = "no";
        addressService.updateAddress(address);
        f = "yes";
        return f;
    }

    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    public String delete(int id)
    {
        addressService.delAddress(id);
        if(addressService.isExist(id)) {
            return "no";
        } else {
            return "yes";
        }
    }

}
