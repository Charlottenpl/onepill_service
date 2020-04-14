package com.User.service;

import com.User.Dao.UserRepository;
import com.google.gson.Gson;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserService {

    @Resource
    UserRepository userRepository;
    Gson gson = new Gson();


}
