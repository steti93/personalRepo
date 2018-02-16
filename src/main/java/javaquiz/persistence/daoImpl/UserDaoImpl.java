package javaquiz.persistence.daoImpl;

import javaquiz.persistence.dao.UserDao;
import javaquiz.persistence.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;
import java.util.Optional;

public abstract class UserDaoImpl implements UserDao{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Optional<User> getByUserName(String userName) {
        List<User> userList = (List<User>) this.findAll();
        return userList.stream()
                .filter(r->r.getName().equals(userName)).findFirst();

    }
}
