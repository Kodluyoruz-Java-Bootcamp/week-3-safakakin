package entity.concretes;

import java.util.List;

import entity.abstracts.Entity;

public class Article implements Entity {
	private int id;
	private int userId;
	private String title;
	private String content;
	private List<Tag> tag;
	//Yayınlanmış ise true, taslak ise false
	private boolean isPublished;
	
	public Article(int id, int userId, String title, String content, boolean isPublished,List<Tag> tag) {
		super();
		this.id = id;
		this.userId = userId;
		this.title = title;
		this.content = content;
		this.isPublished = isPublished;	
		this.tag=tag;
	}
	
	public Article() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public List<Tag> getTag() {
		return tag;
	}

	public void setTag(List<Tag> tag) {
		this.tag = tag;
	}

	public boolean isPublished() {
		return isPublished;
	}

	public void setPublished(boolean isPublished) {
		this.isPublished = isPublished;
	}
}
