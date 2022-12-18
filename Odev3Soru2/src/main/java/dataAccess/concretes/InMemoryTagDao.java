package dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import dataAccess.abstracts.TagDao;
import entity.concretes.Article;
import entity.concretes.Tag;
import entity.concretes.User;

public class InMemoryTagDao implements TagDao {
	
	private static List<Tag> tagList = new ArrayList();
	

	@Override
	public void add(Tag tag) {
		tagList.add(tag);
		System.out.println("Sistemde kayıtlı tagler:");
		for(Tag x : tagList) {
			System.out.println("#"+x.getTitle());
		}
	}

	@Override
	public void update(Tag tag) {

	}

	@Override
	public void delete(Tag tag) {
		Tag tagArticle=(Tag)tagList.stream().filter(t->t.getId()==tag.getId());
		tagList.remove(tagArticle);
		
	}

	@Override
	public Tag get(int id) {

		return (Tag)tagList.stream().filter(t->t.getId()==id);
	}

	@Override
	public List<Tag> getAll() {
		
		return tagList;
	}

}
