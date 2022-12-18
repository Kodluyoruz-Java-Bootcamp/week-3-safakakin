package entity.concretes;

import java.util.List;

import entity.abstracts.Entity;

public class Tag implements Entity {
	private int id;
	private String title;
	private List<Article> article;
	
	public Tag(int id, String title,List<Article> article) {
		super();
		this.id = id;
		this.title = title;
		this.article=article;
	}
	
	public Tag() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<Article> getArticle() {
		return article;
	}

	public void setArticle(List<Article> article) {
		this.article = article;
	}
	
	
	
	
	
}
