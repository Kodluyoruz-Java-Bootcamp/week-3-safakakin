package dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import dataAccess.abstracts.UserDao;
import entity.concretes.User;

public class InMemoryUserDao implements UserDao{
	
	private static List<User> userList=new ArrayList();
	
	
	@Override
	public void add(User user) {
		userList.add(user);
		System.out.println("Sistemde kayıtlı kullanıcılar:");
		for(User x : userList) {
			System.out.println(x.getName()+" "+x.getSurname());
		}
	}

	@Override
	public void delete(User user) {
		User deletingUser=(User)userList.stream().filter(u->u.getId()==user.getId());
		userList.remove(deletingUser);
	}

	@Override
	public User get(int id) {
		return (User)userList.stream().filter(u->u.getId()==id);
	}

	@Override
	public List<User> getAll() {
		return userList;
	}

}
