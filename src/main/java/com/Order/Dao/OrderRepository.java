package com.Order.Dao;

import com.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order,Integer> {

    //根据UserId查询
    public List<Order> findByUserId(int userId);

    //根据medicineId查询
    public List<Order> findByMedicineId(int medicineId);
}
