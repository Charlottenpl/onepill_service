package com.Order.controller;


import com.Order.service.OrderService;
import com.entity.Order;
import com.google.gson.Gson;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/order")
@Api("订单服务器")
public class OrderController {

    @Resource
    OrderService orderService;
    Gson gson = new Gson();

    //添加
    @ApiOperation("添加订单")
    @PostMapping("/add")
    public String add(@RequestParam("json")String json){
        try{
            Order order = gson.fromJson(json,Order.class);
            this.orderService.add(order);
            return "yes";
        }catch (Exception e){
            return "no";
        }
    }

    //删除
    @ApiOperation("删除订单")
    @PostMapping("/delete")
    public String delete(@RequestParam("id") int id){
        try{
            this.orderService.delete(id);
            return "yes";
        }catch (Exception e){
            return "no";
        }
    }

    //根据Id
    @ApiOperation("根据ID查询订单")
    @GetMapping("/findById")
    public String findById(@RequestParam("id")int id){
        return gson.toJson(this.orderService.findById(id));
    }

    //根据userId
    @ApiOperation("根据userId查询订单")
    @GetMapping("/findByUserId")
    public String findByUserId(@RequestParam("userId")int userId){
        return gson.toJson(this.orderService.findByUserId(userId));
    }

    //根据medicineId
    @ApiOperation("根据medicineId查询订单")
    @PostMapping("/findByMedicineId")
    public String findByMedicineId(@RequestParam("medicineId")int medicineId){
        return gson.toJson(this.orderService.findByMedicineId(medicineId));
    }
}
