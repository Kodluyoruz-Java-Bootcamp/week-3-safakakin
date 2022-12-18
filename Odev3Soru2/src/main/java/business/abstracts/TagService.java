package business.abstracts;

import java.util.List;

import entity.concretes.Tag;
import entity.concretes.User;

public interface TagService {
	void add(Tag tag);
	void update(Tag tag);
	void delete(Tag tag);
	User get(int id);
	List<Tag> getAll();
}
