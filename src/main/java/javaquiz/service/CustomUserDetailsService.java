package javaquiz.service;

import javaquiz.persistence.UserRepository;
import javaquiz.persistence.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userDao;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Optional<User> userOptional = userDao.getUserByName(userName);
        userOptional.orElseThrow(() -> new UsernameNotFoundException("Username not found"));
        return userOptional.map(CustomUserDetails::new).get();
    }
}
