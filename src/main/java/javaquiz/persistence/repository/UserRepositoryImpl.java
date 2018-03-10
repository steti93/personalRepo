package javaquiz.persistence.repository;

import javaquiz.persistence.model.Users;

import java.util.Optional;

public abstract class UserRepositoryImpl implements UserRepository{

    @Override
    public Optional<Users> getUserByName(String userName) {
        return findAll().stream()
                .filter(r->r.getName().equals(userName)).findFirst();
    }
}
