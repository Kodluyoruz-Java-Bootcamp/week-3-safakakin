package business.abstracts;

import java.util.List;

import entity.concretes.Article;
import entity.concretes.Tag;
import entity.concretes.User;

public interface UserService {
	void add (User user);
	void delete (User user);
	void followUser(User user,User userToFollow);
	void followTag(User user,int tagId);
	List<User> getAll();
	User get(int id);
}
