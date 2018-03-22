package javaquiz.service;

import javaquiz.persistence.model.Users;

import java.util.List;

public interface UserService {
    void createUser(Users user);

    List<Users> getAllUsersByName(String userName);
}
