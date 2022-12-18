package emlakcepte.service;

import java.util.List;

import emlakcepte.dao.MessageDao;
import emlakcepte.model.Message;

public class MessageService {
	private MessageDao messageDao=new MessageDao();
	
	public void createMessage(Message message) {	
		messageDao.createMessage(message);
	}
	
	public void deleteMessage(Message message) {	
		messageDao.deleteMessage(message);
	}
	
	public void updateMessage(Message message) {	
		messageDao.updateMessage(message);
	}
	
	public List<Message> findAllMessages() {	
		return messageDao.findAllMessages();
	}
	
	public Message findMessageById(int id) {	
		return messageDao.findMessageById(id);
	}
	
}
