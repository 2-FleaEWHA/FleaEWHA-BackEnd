package kr.or.epro.fleaewha.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import kr.or.epro.fleaewha.dto.ChatMessageDTO;

@Controller
public class StompChatController {
	
	private final SimpMessagingTemplate template;
	
	@Autowired
	public StompChatController(SimpMessagingTemplate template) {
		this.template = template;
	}
	
	@MessageMapping(value = "/chat/enter")
	public void enter(ChatMessageDTO message) {
		message.setMessage(message.getWriter()+"님이 입장하였습니다.");
		template.convertAndSend("/sub/chat/room/"+ message.getRoodId(), message);
	}
	
	@MessageMapping(value = "/chat/message")
	public void message(ChatMessageDTO message) {
		template.convertAndSend("/sub/chat/room/"+message.getRoodId(),message);
	}

}
