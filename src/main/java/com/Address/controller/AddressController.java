// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   AddressController.java

package com.Address.controller;

import com.entity.Address;
import com.google.gson.Gson;
import com.Address.service.AddressService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/address")
@Api("地址服务器")
public class AddressController {

    Gson gson = new Gson();
    @Resource
    AddressService addressService;


    //查询所有地址
    @ApiOperation(value = "查询所有地址",notes = "查询数据库中的所有地址")
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public String list()
    {
        java.util.List addressList = addressService.listAll();
        String result = gson.toJson(addressList);
        return result;
    }

    //添加地址
    @ApiOperation(value = "添加地址",notes = "在数据库中插入新的地址")
    @ApiImplicitParam(name = "json", value = "地址的json字符串", paramType = "query", required = true, dataType = "String")
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
    @ApiOperation(value = "更新地址",notes = "在数据库中更新新的地址")
    @ApiImplicitParam(name = "json", value = "地址的json字符串", paramType = "query", required = true, dataType = "String")
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
    @ApiOperation(value = "删除地址",notes = "在数据库中删除地址")
    @ApiImplicitParam(name = "id", value = "地址的ID", paramType = "query", required = true, dataType = "Integer")
    @RequestMapping(value = "/delete",method = RequestMethod.GET)
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
    @ApiOperation(value = "根据UserId查询地址",notes = "在数据库中根据UserId查询地址")
    @ApiImplicitParam(name = "userId", value = "要查询的userId", paramType = "query", required = true, dataType = "Integer")
    @RequestMapping(value = "/findByUserId",method = RequestMethod.GET)
    public List<Address> findAddressByUserId(@RequestParam("userId") int userId){
        return this.addressService.findByUserId(userId);
    }

}

