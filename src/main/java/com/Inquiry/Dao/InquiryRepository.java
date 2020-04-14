package com.Inquiry.Dao;

import com.entity.Inquiry;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InquiryRepository extends JpaRepository<Inquiry,Integer> {

    //根据userId查询
    public List<Inquiry> findByUserId(int id);
    //根据id查询
    public Inquiry findById(int userId);
}
