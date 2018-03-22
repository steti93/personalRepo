package javaquiz.resources;

import javaquiz.common.UserRoleType;
import javaquiz.persistence.model.Feedback;
import javaquiz.persistence.model.Users;
import javaquiz.service.FeedBackService;
import javaquiz.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;

@Controller
public class HomeController {

    private BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    @Autowired
    private FeedBackService feedBackService;

    @Autowired
    private UserService userService;

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @RequestMapping(value = "/feed", method = RequestMethod.POST)
    public ModelAndView submitFeed(@RequestParam("name") String name, @RequestParam("email") String email, @RequestParam("message") String comment) {
        Feedback feedback = new Feedback();
        feedback.setName(name);
        feedback.setEmail(email);
        feedback.setComment(comment);
        feedback.setView(0);
        feedback.setCreatedAt(new Date());
        feedBackService.saveFeddback(feedback);
        ModelAndView returnedMessage = new ModelAndView("redirect:/#contact");
        returnedMessage.addObject("formResponse", true);
        return returnedMessage;

    }

    @RequestMapping(value = "/createUser", method = RequestMethod.POST)
    public String createUser(@RequestParam("name") String name,
                             @RequestParam("email") String email,
                             @RequestParam("lastName") String lastName,
                             @RequestParam("password") String password,
                             Model model) {

        if (userService.getAllUsersByName(name).isEmpty()) {
            Users createdUser = new Users();
            createdUser.setName(name);
            createdUser.setEmail(email);
            createdUser.setLastName(lastName);
            createdUser.setPassword(bCryptPasswordEncoder.encode(password));
            createdUser.setRole(UserRoleType.SIMPLE.toString());
            userService.createUser(createdUser);
            model.addAttribute("warningMessage", "User was registered with success!");

        } else {
            model.addAttribute("warningMessage", "User with name " + name + " already exist!");
        }
        return "index";
    }

    @RequestMapping(value = "/log-in", method = RequestMethod.POST)
    public String logIn(Model model, @RequestParam("username") String userName, @RequestParam("userPassword") String userPassword) {
        Users logInUser;
        try {
            logInUser = userService.getAllUsersByName(userName).get(0);
        } catch (NullPointerException e) {
            logInUser = null;
            e.printStackTrace();
        }

        if (!bCryptPasswordEncoder.matches(userPassword, logInUser.getPassword())) {
            model.addAttribute("responseMessage", "Bad credentials");
            return "index";
        } else {
            if (logInUser.getRole().equals(UserRoleType.ADMIN.toString())) {
                model.addAttribute("responseMessage", "Hello Admin: " + logInUser.getName());
                return "admin";
            } else {
                model.addAttribute("responseMessage", "Hello Simple: " + logInUser.getName());
                return "admin";
            }
        }
    }

}
