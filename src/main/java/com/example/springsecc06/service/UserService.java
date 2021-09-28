package com.example.springsecc06.service;

import com.example.springsecc06.entity.Role;
import com.example.springsecc06.entity.User;
import com.example.springsecc06.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void save(User user){
        Set<Role> roleSet = new HashSet<>();
        roleSet.add(Role.USER);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoles(roleSet);
        userRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Optional<User> byUsername = userRepository.findByUsername(s);
        if (byUsername.isPresent()){
            return byUsername.get();
        } else {
            throw new UsernameNotFoundException(s);
        }
    }
}
