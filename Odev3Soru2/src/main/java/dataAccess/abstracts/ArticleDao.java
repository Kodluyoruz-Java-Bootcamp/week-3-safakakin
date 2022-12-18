package dataAccess.abstracts;

import java.util.List;

import entity.concretes.Article;
import entity.concretes.User;


public interface ArticleDao {
	void add(Article article);
	void delete(int id);
	
	Article get(int id);
	List<Article> getAll();
}
