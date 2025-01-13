package com.example.flower_web.Service;

import org.springframework.stereotype.Service;
import com.example.flower_web.Models.User;
import com.example.flower_web.Repository.UserRepository;


@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public User registerUser(String login, String password, String email){
        if (login == null || password == null) {
            return null;
        } else {
            User usersModel=new User();
            usersModel.setLogin(login);
            usersModel.setPassword(password);
            usersModel.setEmail(email);
            return userRepository.save(usersModel);

        }
    }

    public User authenticate(String login, String password){
        return userRepository.findByLoginAndPassword(login, password).orElse(null);
    }
}
