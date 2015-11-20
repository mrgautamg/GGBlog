package ea.ggblog.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ea.ggblog.domain.Role;
import ea.ggblog.service.RoleService;

@Controller
public class RoleController {

	@Autowired
	RoleService roleservice;

	@RequestMapping(value = "/listRole")
	public String listRole(Model model) {
		model.addAttribute("roles", roleservice.getAll());
		return "listRole";
	}

	@RequestMapping(value = "/addRole", method = RequestMethod.GET)
	public String addRoleForm(@ModelAttribute("role") Role role) {
		return "addRole";
	}

	@RequestMapping(value = "/addRole", method = RequestMethod.POST)
	public String addRole(@Valid @ModelAttribute("addRole") Role role, BindingResult bindingresult,
			HttpServletRequest request, RedirectAttributes redirectAttributes) {
		if (bindingresult.hasErrors()) {

			return "addRole";
		}
		roleservice.save(role);
		redirectAttributes.addFlashAttribute("message", "Added successfully.");
		return "redirect:sucess";
	}

}
