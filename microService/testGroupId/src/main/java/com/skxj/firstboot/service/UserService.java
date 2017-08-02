package com.skxj.firstboot.service;

import com.skxj.firstboot.dao.UserDao;
import com.skxj.firstboot.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by Snow on 7/11/2017.
 */
@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public String show(){

        return "hello world, Snow!";
    }

    public void add(){
        User user = new User();
        user.setName("Snow");
        user.setSex("male");
        user.setBirs(new Date());
        user.setMessage("TEST");
        userDao.add(user);
    }

}
