package javaquiz.resources;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdminController {
    @RequestMapping("/admin")
    public String accessAdminPannel(){
        return "admin page";
    }
}
