package javaquiz.persistence;

import javaquiz.persistence.model.User;

import java.util.Optional;

public abstract class UserRepositoryImpl implements UserRepository{

    @Override
    public Optional<User> getUserByName(String userName) {
        return findAll().stream()
                .filter(r->r.getName().equals(userName)).findFirst();
    }
}
