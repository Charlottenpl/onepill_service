package com.Focus.Dao;

import com.entity.Doctor;
import com.entity.Focus;
import com.entity.Medicine;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FocusRepository extends JpaRepository<Focus,Integer> {

    //查询收藏列表
    public List<Focus> findByUserIdAndUserTypeAndType(int userId,int userType,int type);

    //根据userId和typeId删除
    public void deleteByUserIdAndUserTypeAndTypeIdAndType(int userId,int userType,int typeId,int type);

    //根据userId和typeId查询
    public Focus findFocusByUserIdAndUserTypeAndTypeIdAndType(int userId,int userType,int typeId,int type);
}
