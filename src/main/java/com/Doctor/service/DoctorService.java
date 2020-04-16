package com.Doctor.service;

import com.Doctor.Dao.DoctorRepository;
import com.entity.Doctor;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.print.Doc;
import java.util.List;

@Service
public class DoctorService {

    @Resource
    DoctorRepository doctorRepository;

    //医生登录
    public Doctor doctorLogin(String phone,String password){
        return this.doctorRepository.findDoctorByPhoneAndPassword(phone, password);
    }
    //增加医生
    public boolean add(Doctor doctor){
        try {
            this.doctorRepository.save(doctor);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    //根据ID删除医生
    public void delete(int id){
        this.doctorRepository.deleteById(id);
    }

    //查询所有医生
    public List<Doctor> findAllDoctor(){
        return this.doctorRepository.findAll();
    }

    //根据Id查询医生
    public Doctor findById(int id){
        return this.doctorRepository.findById(id);
    }

    //根据Name查询医生
    public Doctor findByName(String name){
        return this.doctorRepository.findByName(name);
    }

}
