package com.Inquiry.service;

import com.Inquiry.Dao.InquiryRepository;
import com.entity.Inquiry;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class InquiryService {

    @Resource
    InquiryRepository inquiryRepository;

    //查询all
    public List<Inquiry> findAll(){
        return this.inquiryRepository.findAll();
    }

    //插入
    public void add(Inquiry inquiry){
        this.inquiryRepository.save(inquiry);
    }

    //删除
    public void delete(int id){
        this.inquiryRepository.deleteById(id);
    }

    //根据Id查询
    public Inquiry findById(int id){
        return this.inquiryRepository.findById(id);
    }
    //根据userId查询
    public List<Inquiry> findByUserId(int userId){
        return this.inquiryRepository.findByUserId(userId);
    }


}
