package softwareBlog;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import business.abstracts.ArticleService;
import business.abstracts.TagService;
import business.abstracts.UserService;
import business.concretes.ArticleManager;
import business.concretes.TagManager;
import business.concretes.UserManager;
import dataAccess.concretes.InMemoryArticleDao;
import dataAccess.concretes.InMemoryTagDao;
import dataAccess.concretes.InMemoryUserDao;

@Configuration

public class BeanConfig {
	
	@Bean
	public UserService userService() {
		return new UserManager(new InMemoryUserDao());
	}
	
	@Bean
	public TagService tagService() {
		return new TagManager(new InMemoryTagDao());
	}
	
	@Bean
	public ArticleService articleService() {
		return new ArticleManager(new InMemoryArticleDao());
	}


}
