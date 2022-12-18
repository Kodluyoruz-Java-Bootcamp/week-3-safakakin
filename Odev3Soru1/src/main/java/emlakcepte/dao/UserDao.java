package emlakcepte.dao;

import java.util.ArrayList;
import java.util.List;

import emlakcepte.model.Search;
import emlakcepte.model.User;

public class UserDao {
	
	private static List<User> userList = new ArrayList<>();

	public void createUser(User user) {	
		userList.add(user);
	}
	
	public List<User> findAllUsers() {	
		return userList;
	}
	
	public void saveSearch(User user,Search search) {
		user.getSearchList().add(search);
	}

}
