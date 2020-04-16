package com.Doctor.Dao;


import com.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor,Integer> {


    //根据Id查询医生
    public Doctor findById(int id);

    //根据name查询医生
    public Doctor findByName(String name);
}
