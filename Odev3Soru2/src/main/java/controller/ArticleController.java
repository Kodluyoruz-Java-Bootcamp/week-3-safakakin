package controller;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import business.abstracts.ArticleService;
import entity.concretes.Article;
import entity.concretes.User;

@RestController
@RequestMapping("/articles")

public class ArticleController {
	
	@Autowired
	private ArticleService articleManager;
	
	@PostMapping("/add")
	public void add(@RequestBody Article article) {
		articleManager.add(article);
		
	}
	
	@PutMapping("/updatepublishstatus")
	public void updatePublishStatus(@RequestBody Article article) {
		articleManager.updatePublishStatus(article);
	}

	@DeleteMapping("/delete")
	public void delete(@PathVariable int id) {
		articleManager.delete(id);
	}


	@GetMapping("/getall")
	public List<Article> getAll() {
		
		return articleManager.getAll();
	}
	
	@GetMapping("/getarticlesbyuserid")
	public void getArticlesByUserId(@RequestBody User user) {
		articleManager.getArticlesByUserId(user);
	}
}
