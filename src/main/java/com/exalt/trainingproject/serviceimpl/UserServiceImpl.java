package com.exalt.trainingproject.serviceimpl;

import com.exalt.trainingproject.exceptions.ElementNotFoundException;
import com.exalt.trainingproject.model.User;
import com.exalt.trainingproject.repository.UserRepository;
import com.exalt.trainingproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User getById(Integer id) {
        return userRepository.findById(id).orElseThrow(() -> new ElementNotFoundException("User with provided ID not exists"));
    }
}


