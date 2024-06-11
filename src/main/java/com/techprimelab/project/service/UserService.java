package com.techprimelab.project.service;

import com.techprimelab.project.entity.User;

import java.util.List;

public interface UserService {

    User save(User user);

    List<User> findAll();

    User findById(int id);

    void deleteById(int id);

//    User findUserCredential(UserLoginReq userLoginReq);
}
