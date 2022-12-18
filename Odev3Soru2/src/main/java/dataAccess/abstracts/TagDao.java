package dataAccess.abstracts;

import java.util.List;

import entity.concretes.Tag;


public interface TagDao {
	void add(Tag tag);
	void update(Tag tag);
	void delete(Tag tag);
	Tag get(int id);
	List<Tag> getAll();
}
