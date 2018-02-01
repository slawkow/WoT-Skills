package pl.slawek.wotskills.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pl.slawek.wotskills.common.JsonReader;
import pl.slawek.wotskills.model.Player;

@RestController
public class PlayerController {
	
	@RequestMapping("/players/{nickname}")
	public Player getPlayer(@PathVariable String nickname) {
		return JsonReader.getPlayerAccount(nickname);
	}
}
