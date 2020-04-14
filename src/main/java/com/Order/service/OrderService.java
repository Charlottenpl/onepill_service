package com.Order.service;


import com.Order.Dao.OrderRepository;
import com.entity.Order;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.List;

@Service
public class OrderService {

    @Resource
    OrderRepository orderRepository;

    //添加
    public void add(Order order){
        this.orderRepository.save(order);
    }

    //删除
    public void delete(int id){
        this.orderRepository.deleteById(id);
    }

    //根据Id查询
    public Order findById(int id){
       return this.findById(id);
    }
    //根据userId查询
    public List<Order> findByUserId(int userId){
        return this.orderRepository.findByUserId(userId);
    }

    //根据medicineId查询
    public List<Order> findByMedicineId(int medicineId){
        return this.findByMedicineId(medicineId);
    }
}
