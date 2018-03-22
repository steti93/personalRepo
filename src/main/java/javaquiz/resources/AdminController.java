package javaquiz.resources;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AdminController {

    @PreAuthorize("hasAnyRole('ADMIN')")
    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String accessAdminPannel() {
        return "admin/index";
    }
}
