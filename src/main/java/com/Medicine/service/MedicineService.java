package com.Medicine.service;

import com.Medicine.Dao.MedicineRepository;
import com.entity.Inquiry;
import com.entity.Medicine;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class MedicineService {

    @Resource
    MedicineRepository medicineRepository;

    //查询all
    public List<Medicine> findAll(){
        return this.medicineRepository.findAll();
    }

    //插入
    public void add(Medicine medicine){
        this.medicineRepository.save(medicine);
    }

    //删除
    public void delete(int id){
        this.medicineRepository.deleteById(id);
    }

    //根据Id查询
    public Medicine findById(int id){
        return this.medicineRepository.findById(id);
    }

    //根据Name查询
    public Medicine findByName(String name){
        return this.medicineRepository.findByMedicine(name);
    }
}
