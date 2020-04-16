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

    public User userLogin(String phone, String password) {
        return userRepository.findUserByPhoneAndPassword(phone, password);
    }

    //用户（病人）注册
    public boolean userRegister(User user) {
        try {
            userRepository.save(user);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
