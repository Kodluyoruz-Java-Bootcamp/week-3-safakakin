package entity.concretes;

import java.util.List;

import entity.abstracts.Entity;

public class User implements Entity {
	
	private int id;
	private String name;
	private String surname;
	private String email;
	private String password;
	private List<Integer> userIdList;
	private List<Article> articleList;	
	private List<Integer> tagList;
	
	
	public User() {
		
		}
	public User(int id, String name, String surname, String email, String password, 
			List<Article> articleList,List<Integer> tagList, List<Integer> userIdList) {
		super();
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.password = password;
		this.articleList = articleList;
		this.tagList = tagList;
		this.userIdList = userIdList;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Integer> getUserIdList() {
		return userIdList;
	}

	public void setUserIdList(List<Integer> userIdList) {
		this.userIdList = userIdList;
	}
	
	public List<Article> getArticleList() {
		return articleList;
	}
	
	public void setArticleList(List<Article> articleList) {
		this.articleList = articleList;
	}
	
	
	
	public List<Integer> getTagList() {
		return tagList;
	}
	
	public void setTagList(List<Integer> tagList) {
		this.tagList = tagList;
	}
	
	
}
