package dataAccess.concretes;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import dataAccess.abstracts.ArticleDao;
import entity.concretes.Article;
import entity.concretes.User;


public class InMemoryArticleDao implements ArticleDao {
	
	List<Article> articleList=new ArrayList();
	
	@Override
	public void add(Article article) {
		articleList.add(article);
	}


	@Override
	public void delete(int id) {
		for(Iterator<Article> iterator = articleList.iterator();iterator.hasNext();) {
			Article x=iterator.next();
			if(x.getId()==id) {
				iterator.remove();
			}
		}
		
	}

	@Override
	public Article get(int id) {
		
		return (Article)articleList.stream().filter(a->a.getId()==id);
	}

	@Override
	public List<Article> getAll() {
		
		return articleList;
	}
	
	

}
