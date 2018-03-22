package javaquiz;

import javaquiz.common.UserRoleType;
import javaquiz.persistence.model.Users;
import javaquiz.persistence.repository.UserRepository;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.stream.Collectors;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class HomeControllerTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private UserRepository userRepository;

    @Test
    public void getIndex() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void addUsers(){
        if (userRepository.findAll().isEmpty()){
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            Users adminUser = new Users();
            adminUser.setName("admin");
            adminUser.setEmail("admin@admin.com");
            adminUser.setLastName("admin");
            adminUser.setPassword(passwordEncoder.encode("admin"));
            adminUser.setActive(1);
            adminUser.setRole(UserRoleType.ADMIN.toString());
            userRepository.save(adminUser);
        }
    }

    @Test @Ignore
    public void deleteUserByUserName(){
        Users deletedUser = userRepository.getUserByName("admin").get();
        userRepository.delete(deletedUser);
    }
}
