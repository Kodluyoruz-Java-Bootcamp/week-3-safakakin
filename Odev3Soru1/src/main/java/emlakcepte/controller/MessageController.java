package emlakcepte.controller;

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

import emlakcepte.model.Message;
import emlakcepte.service.MessageService;

@RestController
@RequestMapping(value="/messages")
public class MessageController {
	
	@Autowired
	private MessageService messageService;
	
	@PostMapping("/createMessage")
	public void createMessage(@RequestBody Message message) {	
		messageService.createMessage(message);
	}
	
	@DeleteMapping("/deleteMessage")
	public void deleteMessage(@RequestBody Message message) {	
		messageService.deleteMessage(message);
	}
	
	@PutMapping("/updateuser")
	public void updateUser(@RequestBody Message message) {	
		messageService.updateMessage(message);
	}
	
	@GetMapping("/findallmessages")
	public List<Message> findAllMessages() {	
		return messageService.findAllMessages();
	}
	@GetMapping("/findmessagebyid")
	public Message findMessageById(@PathVariable int id) {	
		return messageService.findMessageById(id);
	}
	
}
