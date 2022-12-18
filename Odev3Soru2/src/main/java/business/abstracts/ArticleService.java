package business.abstracts;

import java.util.List;

import entity.concretes.Article;
import entity.concretes.User;

public interface ArticleService {
	void add(Article article);
	void updatePublishStatus(Article article);
	void delete(int id);
	void getArticlesByUserId(User user);
	User get(int id);
	List<Article> getAll();
}
