package com.Focus.service;

import com.Focus.Dao.FocusRepository;
import com.entity.Doctor;
import com.entity.Focus;
import com.entity.Medicine;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.List;

@Service
public class FocusService {

    @Resource
    FocusRepository focusRepository;


    //获取收藏医生列表
    public List<Focus> findDoctorList(int userId,int userType){
        return this.focusRepository.findByUserIdAndUserTypeAndType(userId,userType,1);
    }


    //获取收藏药品列表
    public List<Focus> findMedicine(int userId,int userType){
        return this.focusRepository.findByUserIdAndUserTypeAndType(userId,userType,2);
    }


    //取消收藏
    public void delete(int userId,int userType,int type,int typeId){
        this.focusRepository.deleteByUserIdAndUserTypeAndTypeIdAndType(userId,userType,typeId,type);
    }


    //新增收藏
    public void save(Focus focus){
       this.focusRepository.save(focus);
    }


    //isHave
    public boolean isHave(int userId,int userType,int type,int typeId){
        if (this.focusRepository.findFocusByUserIdAndUserTypeAndTypeIdAndType(userId,userType,typeId,type) != null){
            return true;
        }
        return false;
    }
}
