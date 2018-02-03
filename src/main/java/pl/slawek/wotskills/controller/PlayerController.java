package pl.slawek.wotskills.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.slawek.wotskills.common.JsonReader;
import pl.slawek.wotskills.model.Player;
import pl.slawek.wotskills.model.PlayerVehicleStats;

import java.util.List;

@RestController
public class PlayerController {
	
	@RequestMapping("/players/{nickname}")
	public List<PlayerVehicleStats> getPlayerTanks(@PathVariable String nickname) {
		Player player = JsonReader.getPlayerAccount(nickname);
		return JsonReader.getPlayerVehicleStats(player.getAccountId());
	}
}
