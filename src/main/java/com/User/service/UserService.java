package com.User.service;

import com.User.Dao.UserRepository;
import com.entity.User;
import com.google.gson.Gson;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserService {

    @Resource
    UserRepository userRepository;

    //用户登陆
    public User userLogin(String phone,String password){
        return userRepository.findUserByPhoneAndPassword(phone, password);
    }

    //添加用户
    public void save(User user){
        this.userRepository.save(user);
    }

    //删除用户
    public void delete(int id){
        this.userRepository.deleteById(id);
    }

    //根据Id查询用户
    public User findById(int id){
        return this.userRepository.findById(id);
    }
}
