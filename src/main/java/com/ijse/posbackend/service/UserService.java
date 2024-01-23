package com.ijse.posbackend.service;


import com.ijse.posbackend.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    List<User> getAllUsers();
    User createUser(User user);

    User getUserById(Long id);
}
