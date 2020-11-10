package com.praktijk3.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.praktijk3.model.role;
import com.praktijk3.model.user;
import com.praktijk3.repository.roleRepository;
import com.praktijk3.repository.userRepository;
import java.util.Arrays;
import java.util.HashSet;

@Service("userService")
public class userServiceImpl implements userService {
 
 @Autowired
 private userRepository userRepository;
 
 @Autowired
 private roleRepository roleRespository;
 
 @Autowired
 private BCryptPasswordEncoder bCryptPasswordEncoder;

 @Override
 public user findUserByEmail(String email) {
  return userRepository.findByEmail(email);
 }

 @Override
 public void saveUser(user user) {
  user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
  user.setActive(1);
  role userRole = roleRespository.findByRole("ADMIN");
  user.setRoles(new HashSet<role>(Arrays.asList(userRole)));
  userRepository.save(user);
 }

}