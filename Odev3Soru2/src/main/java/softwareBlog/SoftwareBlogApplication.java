package softwareBlog;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import business.abstracts.ArticleService;
import business.abstracts.TagService;
import business.abstracts.UserService;
import entity.concretes.Article;
import entity.concretes.Tag;
import entity.concretes.User;

@SpringBootApplication
public class SoftwareBlogApplication {

	public static void main(String[] args) {
		SpringApplication.run(SoftwareBlogApplication.class, args);
		
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(BeanConfig.class);
		
		UserService userService=applicationContext.getBean(UserService.class);
		TagService tagService=applicationContext.getBean(TagService.class);
		ArticleService articleService=applicationContext.getBean(ArticleService.class);
		
		
		User user1=new User(1,"Şafak","Akın","safakakin@hotmail.com.tr","123456",new ArrayList(),new ArrayList(),new ArrayList());
		User user2=new User(2,"Başak","Akın","basakakin@hotmail.com.tr","123456",new ArrayList(),new ArrayList(),new ArrayList());
		User user3=new User(3,"Beyza","Akın","beyzaakin@hotmail.com.tr","123456",new ArrayList(),new ArrayList(),new ArrayList());
		User user=new User(4,"Mariam","Akın","mariam@hotmail.com.tr","123456",new ArrayList(),new ArrayList(),new ArrayList());
		
		userService.add(user);
		userService.add(user1);
		userService.add(user2);
		userService.add(user3);
		
		Tag tag1=new Tag(1,"JavaScript",null);
		Tag tag2=new Tag(2,"C#",null);
		Tag tag3=new Tag(3,"Java",null);
		
		tagService.add(tag1);
		tagService.add(tag2);
		tagService.add(tag3);
		
		//Blog yayınlama (published durumu false ise taslak, değil ise doğrudan yayınlama)
		Article article=new Article(1,1,"Java Referans Tipler","Java'da referans tipler önemlidir",false,List.of(tag1,tag2));
		Article article2=new Article(2,1,"C# Referans Tipler","C#'da referans tipler önem arz eder",false,List.of(tag1,tag2));
		Article article3=new Article(3,1,"Phyton Referans Tipler","Phytonda'da referans tipler önemlidir",false,List.of(tag1,tag2));
		
		articleService.add(article);
		articleService.add(article2);
		articleService.add(article3);
		
		for(Article x : articleService.getAll()) {
			System.out.println(x.getContent());
		}
		
		//Blog silme
		
		articleService.delete(article2.getId());
		
		for(Article x : articleService.getAll()) {
			System.out.println(x.getContent()+" "+x.isPublished());
		}
		
		//Taslak yazıyı yayına alma
		articleService.updatePublishStatus(article);
		
		//Bir kullanıcının başka bir kullanıcıyı takip etmesi
		userService.followUser(user, user1);
		//Takip edilenlerin listelenerek metotun kontrol edilmesi
		for(User x : userService.getAll()){
			if(x.getId()==user.getId()) {
				for(Integer y :x.getUserIdList()) {
					System.out.println(y);
				}
			}
		}
		// Girilen kullanıcının yayınlamış olduğu makaleleri getirir.
		articleService.getArticlesByUserId(user1);
		
		//Kullanıcının tag takip etmesi
		
		userService.followTag(user, 2);
			
	}

}
