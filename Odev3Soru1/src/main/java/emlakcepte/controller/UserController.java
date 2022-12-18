package emlakcepte.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import emlakcepte.model.ProvinceWindow;
import emlakcepte.model.Search;
import emlakcepte.model.User;
import emlakcepte.service.UserService;

@RestController
@RequestMapping(value="users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	//Arama kayıt endpointi
	@PostMapping("savesearch")
	public ResponseEntity<User> saveSearch(@RequestBody User user,@RequestBody Search search){
		userService.saveSearch(user, search);
		return new ResponseEntity<>(user,HttpStatus.CREATED);
	}
}
