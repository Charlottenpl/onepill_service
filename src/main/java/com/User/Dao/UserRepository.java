package com.User.Dao;

import com.entity.Comment;
import com.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
    //根据电话和密码查找用户
    public User findUserByPhoneAndPassword(String phone,String password);

    //根据Id查询用户
    public User findById(int id);

}
