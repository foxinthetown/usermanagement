package com.usermanagement.app.service;

import com.usermanagement.app.entiry.User;
import com.usermanagement.app.entiry.UserId;
import com.usermanagement.app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.usermanagement.app.entiry.DateConverter.convertDateToString;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User addUser(User user) {
        if (!isUserExist(user)) {
            userRepository.saveAndFlush(user);
        } else {
            long id = findUserByName(user).getId();
            updateUserInfoById(id, user.getEmail(), user.getPhone());
        }
        return user;
    }

    private boolean isUserExist(User user) {
        UserId userId = user.getUserId();
        return userRepository.isUserExist(userId.getFirstName(), userId
                .getLastName(), convertDateToString(userId.getDob())) == 1;
    }

    private User findUserByName(User user) {
        UserId userId = user.getUserId();
        return userRepository.findByName(userId.getFirstName(), userId
                .getLastName(), userId.getDob());
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

    public User findUserById(long id) {
        return userRepository.findById(id).get();
    }

    public void deleteUserById(long id) {
        userRepository.deleteById(id);
    }
}
