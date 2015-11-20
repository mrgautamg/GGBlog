package ea.ggblog.controller;


import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ea.ggblog.domain.Comment;
import ea.ggblog.domain.Post;
import ea.ggblog.domain.Role;
import ea.ggblog.domain.User;
import ea.ggblog.service.CommentService;
import ea.ggblog.service.PostService;
import ea.ggblog.service.UserService;

@Controller
public class CommentController {

	@Autowired
	CommentService commentservice;

	@Autowired
	PostService postservice;
	@Autowired
	UserService userservice;
	

	@RequestMapping(value = "/addComment", method = RequestMethod.POST)
	public String addComment(@RequestParam("id") int id,@Valid @ModelAttribute("comment") Comment comment) {
		//System.out.println(comment.getPost().getId());
		Post post=postservice.getById(id);
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String username=authentication.getName();
		User user = (User)userservice.getByName(username);
//		comment.setPost(post);
//		comment.setUser(user);
//		
//		post.getComments().add(comment);
		Comment comment1=new Comment(user,post);
		comment1.setDescription(comment.getDescription());
		post.getComments().add(comment1);
		//postservice.save(post);
		commentservice.save(comment1);
		return "redirect:/listPost";
	}
	
		
	
	
}
