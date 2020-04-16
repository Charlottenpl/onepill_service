package com.User.service;

import com.User.Dao.DoctorRepository;
import com.entity.Doctor;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
@Service
public class DoctorService {

    @Resource
    DoctorRepository doctorRepository;
    public Doctor doctorLogin(String phone,String password){
        return this.doctorRepository.findDoctorByPhoneAndPassword(phone, password);
    }
}
