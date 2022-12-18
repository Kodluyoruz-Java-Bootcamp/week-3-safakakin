package business.concretes;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import business.abstracts.ArticleService;
import business.abstracts.UserService;
import dataAccess.abstracts.ArticleDao;
import dataAccess.abstracts.UserDao;
import entity.concretes.Article;
import entity.concretes.Tag;
import entity.concretes.User;
import softwareBlog.BeanConfig;

public class UserManager implements UserService{
	
	private UserDao userDao;
	
	
	public UserManager(UserDao userDao) {
		super();
		this.userDao = userDao;
		
	}

	@Override
	public void add(User user) {
		userDao.add(user);
		
	}

	@Override
	public void delete(User user) {
		userDao.delete(user);
	}

	@Override
	public List<User> getAll() {
		return userDao.getAll();
	}

	@Override
	public User get(int id) {
		return userDao.get(id);
	}

	@Override
	public void followUser(User user,User userToFollow) {
		for(Iterator<User> iterator = userDao.getAll().iterator();iterator.hasNext();) {
			User x=iterator.next();
			if(x.getId()==user.getId()) {
				x.getUserIdList().add((Integer)userToFollow.getId());
			}
		}
	}

	@Override
	public void followTag(User user, int tagId) {
		for(Iterator<User> iterator = userDao.getAll().iterator();iterator.hasNext();) {
			User x=iterator.next();
			if(x.getId()==user.getId()) {
				x.getTagList().add((Integer)tagId);
			}
		}
		
	}

	

}
