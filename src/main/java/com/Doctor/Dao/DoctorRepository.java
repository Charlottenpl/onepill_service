package com.Doctor.Dao;


import com.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor,Integer> {

    //医生根据电话号码和密码登录
    public Doctor findDoctorByPhoneAndPassword(String phone,String password);

    //根据Id查询医生
    public Doctor findById(int id);

    //根据name查询医生
    public Doctor findByName(String name);
}
