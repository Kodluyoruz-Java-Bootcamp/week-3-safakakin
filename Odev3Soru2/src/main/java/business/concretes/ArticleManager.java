package business.concretes;

import java.util.Iterator;
import java.util.List;

import business.abstracts.ArticleService;
import dataAccess.abstracts.ArticleDao;
import entity.concretes.Article;
import entity.concretes.User;

public class ArticleManager implements ArticleService {
	
	private ArticleDao articleDao;
	
	public ArticleManager(ArticleDao articleDao) {
		super();
		this.articleDao = articleDao;
	}

	@Override
	public void add(Article article) {
		articleDao.add(article);
		
	}
	
	@Override
	public void updatePublishStatus(Article article) {
		
		
		for(Iterator<Article> iterator = articleDao.getAll().iterator();iterator.hasNext();) {
			Article x=iterator.next();
			if(x.getId()==article.getId()&&x.isPublished()==false) {
				x.setPublished(true);
				System.out.println(x.getTitle()+" başlıklı makaleniz yayınlandı.");
			}
		}
	}

	@Override
	public void delete(int id) {
		articleDao.delete(id);
	}

	@Override
	public User get(int id) {

		return null;
	}

	@Override
	public List<Article> getAll() {
		
		return articleDao.getAll();
	}
	
	@Override
	public void getArticlesByUserId(User user) {
		for(Iterator<Article> iterator = articleDao.getAll().iterator();iterator.hasNext();) {
			Article x=iterator.next();
			if(x.getUserId()==user.getId()) {
				System.out.println(x.getTitle());
			}
		}
		
	}

}
