package com.Order.controller;


import com.Medicine.service.MedicineService;
import com.Order.service.OrderService;
import com.entity.*;
import com.google.gson.Gson;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/order")
@Api("订单服务器")
public class OrderController {

    @Resource
    OrderService orderService;
    @Resource
    MedicineService medicineService;
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
        List<Order> orderList = this.orderService.findByUserId(userId);
        List<MyOrder> myOrderList = new ArrayList<>();
        Medicine medicine = null;
        for (int i= 0;i<orderList.size();i++) {
            MyOrder myOrder = new MyOrder();
            Order order= orderList.get(i);
            medicine = this.medicineService.findById(order.getMedicineId());
            myOrder.setId(order.getId());
            myOrder.setUserId(order.getUserId());
            myOrder.setMedicineId(order.getMedicineId());
            myOrder.setCount(order.getCount());
            myOrder.setImg(order.getImg());
            myOrder.setStatus(order.getStatus());
            int price =medicine.getPrice();
            myOrder.setPrice(price*order.getCount());

            myOrderList.add(i,myOrder);
        }
        String result = gson.toJson(myOrderList);
        System.out.println(result);
        return result;
    }

    //根据medicineId
    @ApiOperation("根据medicineId查询订单")
    @PostMapping("/findByMedicineId")
    public String findByMedicineId(@RequestParam("medicineId")int medicineId){
        return gson.toJson(this.orderService.findByMedicineId(medicineId));
    }
}
