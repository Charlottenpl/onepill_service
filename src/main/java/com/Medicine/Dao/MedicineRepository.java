package com.Medicine.Dao;

import com.entity.Medicine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicineRepository extends JpaRepository<Medicine,Integer> {

    //根据Id查询
    public Medicine findById(int id);

}
