package kr.or.epro.fleaewha.controller;

import java.util.*;

import org.slf4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.or.epro.fleaewha.chatRepo.ChatRoomRepository;

@Controller
@RequestMapping(value = "/chat")
public class RoomController {
	
	private final ChatRoomRepository repository;
	
	public RoomController(ChatRoomRepository repository) {
		this.repository = repository;
	}
	
	@GetMapping(value="/rooms")
	public ModelAndView rooms() {
		
		
		ModelAndView mv = new ModelAndView("chat/rooms");
		
		mv.addObject("list", repository.findAllRooms());
		
		return mv;
	}
	
	@PostMapping(value = "/room")
	public String create(@RequestParam String name, RedirectAttributes rttr) {
		
		rttr.addFlashAttribute("roomName", repository.createChatRoomDTO(name));
		return "redirect:/chat/rooms";
	}
	
	@GetMapping("/room")
	public void getRoom(String roomId, Model model) {
		
		model.addAttribute("room", repository.findRoomById(roomId));
	}

}
