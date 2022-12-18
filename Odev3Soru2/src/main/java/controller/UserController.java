package controller;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import business.abstracts.UserService;
import entity.concretes.User;

@RestController
@RequestMapping("/users")
public class UserController {
	@Autowired
	private UserService userManager;
	
	@PostMapping("/add")
	public void add(@RequestBody User user) {
		userManager.add(user);
	}

	@DeleteMapping("/delete")
	public void delete(@RequestBody User user) {
		userManager.delete(user);
	}

	@GetMapping("/getall")
	public List<User> getAll() {
		return userManager.getAll();
	}

	@GetMapping("/getuserbyid")
	public User get(int id) {
		return userManager.get(id);
	}

	@GetMapping("/followuser")
	public void followUser(@RequestBody User user,@RequestBody User userToFollow) {
		userManager.followUser(user, userToFollow);
	}

	@GetMapping("/followtag")
	public void followTag(@RequestBody User user, @PathVariable int tagId) {
		userManager.followTag(user, tagId);
		
	}

}
