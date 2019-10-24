package com.springRest.service;

import com.springRest.DAO.UserRepository;
import com.springRest.enitity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService
{
    @Autowired
    private UserRepository repository;

    public UserService(UserRepository userRepository)
    {
        this.repository = userRepository;
    }
    public void save(User user)
    {
        try
        {
            repository.save(user);
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
