package javaquiz;

import javaquiz.persistence.UserRepository;
import javaquiz.persistence.model.Role;
import javaquiz.persistence.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
public class TestDataAutentification {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void createUsers() {
        Date currentDate = Date.valueOf(LocalDate.now());
        User user = new User();
        user.setName("admin");
        user.setLastName("admin");
        user.setEmail("admin@admin.com");
        user.setPassword("admin");
        user.setActive(true);
        user.setCreatedAt(currentDate);
        user.setUpdatedAt(currentDate);

        Role role = new Role();
        role.setRoleName("ADMIN");
        role.setCreatedAt(currentDate);

        List<Role> roles = new ArrayList<>();
        roles.add(role);
        user.setRoles(roles);

        userRepository.save(user);

    }
}
