package javaquiz.persistence;

import javaquiz.persistence.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<Users, Integer> {
    public Optional<Users> getUserByName(String userName);
}
