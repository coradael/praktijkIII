package com.praktijk3.service;

import com.praktijk3.model.user;

public interface userService {
  
 public user findUserByEmail(String email);
 
 public void saveUser(user user);
}