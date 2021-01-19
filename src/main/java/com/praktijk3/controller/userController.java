package com.praktijk3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.praktijk3.payload.userProfile;
import com.praktijk3.payload.userSummary;
import com.praktijk3.service.userPrincipal;
import com.praktijk3.repository.userRepository;
import com.praktijk3.model.user;


@RestController
@RequestMapping("/api")
public class userController {
	@Autowired
    private userRepository userRepository;



    @GetMapping("/user/me")
    @PreAuthorize("hasRole('USER')")
    public userSummary getCurrentUser( userPrincipal currentUser) {
        userSummary userSummary = new userSummary(currentUser.getId(), currentUser.getUsername(), currentUser.getName());
        return userSummary;
    }


    @GetMapping("/users/{username}")
    public userProfile getUserProfile(@PathVariable(value = "username") String username) {
        user user = userRepository.findByUsername(username)
               
                		.orElseThrow(() -> new IllegalStateException("username niet gevonden"));
                		
        userProfile userProfile = new userProfile(user.getId(), user.getUsername(), user.getName()
        		
       		);

       return userProfile;
    }

}