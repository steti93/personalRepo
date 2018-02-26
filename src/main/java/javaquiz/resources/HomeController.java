package javaquiz.resources;

import javaquiz.persistence.dao.FeedbackDao;
import javaquiz.persistence.model.Feedback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;

@Controller
public class HomeController {

    @Autowired
    private FeedbackDao feedbackDao;

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
        feedbackDao.save(feedback);
        return new ModelAndView("redirect:/#contact", HttpStatus.OK);

    }

}
