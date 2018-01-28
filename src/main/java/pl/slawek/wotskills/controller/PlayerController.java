package pl.slawek.wotskills.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pl.slawek.wotskills.model.Player;

@RestController
public class PlayerController {
	
	@RequestMapping("/player")
	public Player getPlayer() {
		return new Player("slawek", 123456);
	}
}
