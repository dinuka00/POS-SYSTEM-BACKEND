package com.ijse.posbackend.service;

import com.ijse.posbackend.dto.UserPwDTO;
import com.ijse.posbackend.entity.User;
import com.ijse.posbackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User createUser(User user){
        return userRepository.save(user);
    }

    @Override
    public User getUserById(Long id){
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public User changUserPassword(Long id, UserPwDTO userPwDTO){
         User user = userRepository.findById(id).orElse(null);

         if(user != null){
             user.setPassword(userPwDTO.getPassword());
             return userRepository.save(user);
         }else {
             return null;
         }
    }




}
