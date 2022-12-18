package emlakcepte.dao;

import java.util.ArrayList;
import java.util.List;

import emlakcepte.model.Message;


public class MessageDao {
	
	private static List<Message> messageList = new ArrayList<>();
	
	public void createMessage(Message message) {	
		messageList.add(message);
	}
	
	public void deleteMessage(Message message) {	
		Message messageToDelete;
		messageToDelete=((Message)messageList.stream().filter(m->m.getId()==message.getId()));
		messageList.remove(messageToDelete);
	}
	
	public void updateMessage(Message message) {	
		Message messageToUpdate;
		messageToUpdate=((Message)messageList.stream().filter(m->m.getId()==message.getId()));
		messageToUpdate.setFrom(message.getFrom());
		messageToUpdate.setTo(message.getTo());
		messageToUpdate.setContent(message.getContent());
		messageToUpdate.setTitle(message.getTitle());
	}
	
	public List<Message> findAllMessages() {	
		return messageList;
	}
	
	public Message findMessageById(int id) {	
		return ((Message)messageList.stream().filter(m->m.getId()==id));
	}
}
