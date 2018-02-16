package javaquiz.persistence.dao;

import javaquiz.persistence.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserDao extends CrudRepository<User,Integer> {
    Optional<User> getByUserName(String userName);
}
