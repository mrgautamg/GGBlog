package ea.ggblog.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;


import ea.ggblog.service.UserService;
@Controller
@SessionAttributes("today")
public class LoginController {
	@Autowired
	UserService userservice;

	@RequestMapping(value={"/login"}, method = RequestMethod.GET)
	public String login(Model model) {
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		
		model.addAttribute("today",dateFormat.format(date));
 		return "login";
	}

	@RequestMapping(value={"/welcome"}, method = RequestMethod.GET)
    public String inputProduct(ea.ggblog.domain.User user,Model model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	      String name = auth.getName();
		
		model.addAttribute("user",userservice.getByName(name));
        return "welcome";
    }
	@RequestMapping(value="/loginfailed", method = RequestMethod.GET)
	public String loginerror(Model model) {
 
		model.addAttribute("error", "true");
		return "login";
 
	}
 
	@RequestMapping(value="/logout", method = RequestMethod.GET)
	public String logout(Model model,SessionStatus status) {
		status.setComplete();
 		return "redirect:/login";
 	}
}
