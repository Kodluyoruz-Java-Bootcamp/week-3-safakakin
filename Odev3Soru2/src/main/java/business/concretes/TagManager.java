package business.concretes;

import java.util.List;

import business.abstracts.TagService;
import dataAccess.abstracts.TagDao;
import entity.concretes.Tag;
import entity.concretes.User;

public class TagManager implements TagService {
	private TagDao tagDao;
	
	public TagManager(TagDao tagDao) {
		super();
		this.tagDao = tagDao;
	}

	@Override
	public void add(Tag tag) {
		this.tagDao.add(tag);
	}

	@Override
	public void update(Tag tag) {

	}

	@Override
	public void delete(Tag tag) {
		
	}

	@Override
	public User get(int id) {
		return null;
	}

	@Override
	public List<Tag> getAll() {
		return null;
	}

}
