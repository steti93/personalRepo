package javaquiz.service;

import javaquiz.persistence.dao.UserDao;
import javaquiz.persistence.daoImpl.UserDaoImpl;
import javaquiz.persistence.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private UserDao userDao;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
       User user = userDao.getByUserName(userName);
        return new CustomUserDetails(user);
    }
}
