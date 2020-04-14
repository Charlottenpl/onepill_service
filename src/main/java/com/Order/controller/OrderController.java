package com.Order.controller;


import com.Order.service.OrderService;
import com.entity.Order;
import com.google.gson.Gson;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Resource
    OrderService orderService;
    Gson gson = new Gson();

    //添加
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
    @PostMapping("/findById")
    public String findById(@RequestParam("id")int id){
        return gson.toJson(this.orderService.findById(id));
    }

    //根据userId
    @PostMapping("/findByUserId")
    public String findByUserId(@RequestParam("userId")int userId){
        return gson.toJson(this.orderService.findByUserId(userId));
    }

    //根据medicineId
    @PostMapping("/findByMedicineId")
    public String findByMedicineId(@RequestParam("medicineId")int medicineId){
        return gson.toJson(this.orderService.findByMedicineId(medicineId));
    }
}
