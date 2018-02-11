package javaquiz.persistence.dao;

import javaquiz.persistence.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserDao extends CrudRepository<User,Integer> {
    User getByUserName(String userName);
}
