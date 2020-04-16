package com.User.Dao;

import com.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor,Integer> {
    //医生根据电话号码和密码登录
    public Doctor findDoctorByPhoneAndPassword(String phone,String password);
}
