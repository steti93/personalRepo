package javaquiz.service;

import javaquiz.persistence.model.Users;
import javaquiz.persistence.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public void createUser(Users user) {
        userRepository.save(user);
    }
}
