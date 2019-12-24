package com.example.himiko.dao;

import com.example.himiko.pojo.UserInfo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao {

     List<UserInfo> findUserAll();
     void addUser(UserInfo userInfo);
     void deleteUserById(String userId);
}
