package ea.ggblog.controller;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ea.ggblog.domain.User;
import ea.ggblog.service.UserService;
import ea.ggblog.service.RoleService;

@Controller
// @RequestMapping("/User")
public class UserController {

	@Autowired
	UserService userservice;
	@Autowired
	RoleService roleservice;

	@RequestMapping(value = { "/success" }, method = RequestMethod.GET)
	public String getUserSucessForm() {
		return "sucess";
	}

	@RequestMapping(value = { "/addUser" }, method = RequestMethod.GET)
	public String addUserForm(@ModelAttribute("addUser") User user, Model model) {
		model.addAttribute("role", roleservice.getAll());
		return "addUserForm";
	}

	@RequestMapping(value = { "/addUser" }, method = RequestMethod.POST)
	public String inputaddUserForm(@Valid @ModelAttribute("addUser") User user, BindingResult bindingresult,
			Model model, HttpServletRequest request, RedirectAttributes redirectAttributes) {
		if (bindingresult.hasErrors()) {

			return "addUserForm";
		}

		MultipartFile userImage = user.getImage();

		String rootDirectory = request.getSession().getServletContext().getRealPath("/");

		// isEmpty means file exists BUT NO Content
		if (userImage != null && !userImage.isEmpty()) {

			try {
				long unixTime = System.currentTimeMillis() / 1000L;
				String imageName = user.getUsername() + unixTime + ".png";
				userImage.transferTo(new File(rootDirectory + "\\resources\\images\\" + imageName));
				user.setImageUrl(imageName);// .setUserImagepath(imageName);
			} catch (Exception e) {
				throw new RuntimeException("User Image saving failed", e);
			}
		}
	
		int roleid=user.getRole().getId();
		userservice.save(user,roleid);
		redirectAttributes.addFlashAttribute("flashAttribute", user);
		redirectAttributes.addFlashAttribute("message", "Added successfully.");
		return "redirect:sucess";

	}

	@RequestMapping(value = { "/listUser" })
	public ModelAndView allProducts() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("userDetails", userservice.getAll());
		modelAndView.setViewName("listUser");
		return modelAndView;
	}

}
