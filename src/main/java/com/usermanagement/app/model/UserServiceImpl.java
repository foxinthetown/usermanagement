package com.usermanagement.app.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.usermanagement.app.model.DateConverter.convertDateToString;

@Service
public class UserServiceImpl {

    @Autowired
    UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User addUser(User user) {
        userRepository.saveAndFlush(user);
        return user;
    }

    public User findUserById(long id) {
        return userRepository.findById(id).get();
    }

    public User findUserByName(User user) {
        return userRepository.findByName(user.userId.getFirstName(), user
                .userId.getLastName(), user.userId.getDof());
    }

    public boolean isUserExist(User user) {
        return userRepository.isUserExist(user.userId.getFirstName(), user
                .userId.getLastName(), convertDateToString(user.userId.getDof())) == 1;
    }

    public void updateUserInfoById(long id, String email, String phone) {
        if (!email.isEmpty() && !phone.isEmpty()) {
            userRepository.updateUserInfo(email, phone, id);
        } else if (!email.isEmpty()) {
            userRepository.updateUserEmail(email, id);
        } else if (!phone.isEmpty()) {
            userRepository.updateUserPhone(phone, id);
        }
    }

    public void deleteUserById(long id) {
        userRepository.deleteById(id);
    }
}
