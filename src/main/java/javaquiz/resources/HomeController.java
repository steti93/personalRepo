package javaquiz.resources;

import javaquiz.persistence.model.Feedback;
import javaquiz.persistence.model.Users;
import javaquiz.service.FeedBackService;
import javaquiz.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
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
    public ModelAndView createUser(@RequestParam("name") String name,
                                   @RequestParam("email") String email,
                                   @RequestParam("lastName") String lastName,
                                   @RequestParam("password") String password) {
        Users createdUser = new Users();
        createdUser.setName(name);
        createdUser.setEmail(email);
        createdUser.setLastName(lastName);
        createdUser.setPassword(bCryptPasswordEncoder.encode(password));
        ModelAndView returnedMessage = new ModelAndView("index");
        returnedMessage.addObject("formResponse", true);
        return returnedMessage;
    }

}
