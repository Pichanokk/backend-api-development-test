package com.example.backendapi;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    private List<User> userList = new ArrayList<>();
    private long nextId = 1;

    public UserService() {
        userList.add(new User(nextId++,
                "Glenna Reichert",
                "Delphine",
                "Chaim_McDermott@dana.io",
                "(775)976-6794 x41206",
                "conrad.com"));
        userList.add(new User(nextId++,
                "Kurtis Weissnat",
                "Elwyn.Skiles",
                "Telly.Hoeger@billy.biz",
                "210.067.6132",
                "elvis.io"));
    }

    public List<User> getAllUsers() {
        return userList;
    }

    public User getUserById(Long id) {
        for (User user : userList) {
            if (user.getId().equals(id)) {
                return user;
            }
        }
        return null;
    }

    public User createUser(User user) {
        user.setId(nextId++);
        userList.add(user);
        return user;
    }

    public User updateUser(Long id, User updatedUser) {
        for (int i = 0; i < userList.size(); i++) {
            User currentUser = userList.get(i);
            if (currentUser.getId().equals(id)) {
                updatedUser.setId(id);
                userList.set(i, updatedUser);
                return updatedUser;
            }
        }
        return null;
    }

    public boolean deleteUser(Long id) {
        for (int i = 0; i < userList.size(); i++) {
            if (userList.get(i).getId().equals(id)) {
                userList.remove(i);
                return true;
            }
        }
        return false;
    }
}
