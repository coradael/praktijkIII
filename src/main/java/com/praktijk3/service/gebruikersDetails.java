package com.praktijk3.service;

import com.praktijk3.model.user;
import com.praktijk3.repository.userRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

// importante
@Service
public class gebruikersDetails implements UserDetailsService {

    @Autowired
    userRepository userRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String usernameOrEmail)
            throws UsernameNotFoundException {
        
        user user = userRepository.findByUsernameOrEmail(usernameOrEmail, usernameOrEmail)
                .orElseThrow(() -> 
                        new UsernameNotFoundException("Gebruiker niet gevonden met gebruikersnaam of e-mailadres " + usernameOrEmail)
        );

        return userPrincipal.create(user);
    }

    
    @Transactional
    public UserDetails loadUserById(Long id) {
        user user = userRepository.findById(id).orElseThrow(
            () -> new UsernameNotFoundException("Gebruiker niet gevonden met id: " + id)
        );

        return userPrincipal.create(user);
    }
}