package javaquiz.service;

import javaquiz.persistence.model.Users;
import javaquiz.persistence.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public void createUser(Users user) {
        userRepository.save(user);
    }

    @Override
    public List<Users> getAllUsersByName(String userName) {
        return userRepository.findAll().stream()
                .filter(r -> r.getName().equals(userName)).collect(Collectors.toList());
    }
}
