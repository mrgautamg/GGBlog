package ea.ggblog.controller;

import javax.servlet.http.HttpServletRequest;

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
import ea.ggblog.domain.User;
import ea.ggblog.service.PostService;
import ea.ggblog.service.UserService;

@Controller

public class PostController {
	
	@Autowired
	PostService postservice;
	@Autowired
	UserService userservice;
	
	@RequestMapping(value={"/listPost","","/"})
	public String getAllPosts(Model model){
		model.addAttribute("posts", postservice.getAll());
		return "allPosts";
		
	}
	
		
	@RequestMapping(value={"/newpost"},method=RequestMethod.GET)
	public String addNewPostForm(@ModelAttribute("post") Post post){
		
		return "newPost";
	}
	
	@RequestMapping(value={"/fullPost"},method=RequestMethod.GET)
	public String fullPostForm(@RequestParam("id") int id,Model model){
		Post post=postservice.getById(id);
		model.addAttribute("post",post);
		
		model.addAttribute("comment",new Comment());
		return "fullPost";
	}
	
	@RequestMapping(value={"/editPost"},method=RequestMethod.GET)
	public String updatePostForm(@RequestParam("id") int id,Model model){
		Post post=postservice.getById(id);
		model.addAttribute("post",post);
		
		model.addAttribute("comment",new Comment());
		return "editPost";
	}
	
	
	@RequestMapping(value={"/newpost"},method=RequestMethod.POST)
	public String addNewPost(@ModelAttribute("post") Post post, BindingResult bindingresult,
			HttpServletRequest request, RedirectAttributes redirectAttributes) {
		if (bindingresult.hasErrors()) {

			return "newPost";
		}
		postservice.save(post);
		redirectAttributes.addFlashAttribute("message", "Added successfully.");
		return "redirect:success";
	}
	
	@RequestMapping(value={"/editPost"},method=RequestMethod.POST)
	public String updatePost(@RequestParam("id") int id, Post post, BindingResult bindingresult,
			HttpServletRequest request, RedirectAttributes redirectAttributes) {
		if (bindingresult.hasErrors()) {

			return "editPost";
		}
		//System.out.println(post.getId());
		post.setId(id);
		postservice.update(post);
		redirectAttributes.addFlashAttribute("message", "Saved successfully.");
		return "redirect:success";
	}
	
}
