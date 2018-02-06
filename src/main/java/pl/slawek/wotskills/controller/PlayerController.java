package pl.slawek.wotskills.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.slawek.wotskills.common.JsonReader;
import pl.slawek.wotskills.model.Player;
import pl.slawek.wotskills.model.PlayerVehicleStats;
import pl.slawek.wotskills.model.Vehicle;
import pl.slawek.wotskills.service.VehiclesService;

import java.util.List;

@RestController
public class PlayerController {

    private VehiclesService vehiclesService;

    @Autowired
    public PlayerController(VehiclesService vehiclesService) {
        this.vehiclesService = vehiclesService;
    }

	@RequestMapping("/players/{nickname}")
	public List<PlayerVehicleStats> getPlayerTanks(@PathVariable String nickname) {
		Player player = JsonReader.getPlayerAccount(nickname);
		return JsonReader.getPlayerVehicleStats(player.getAccountId());
	}

    @RequestMapping("/tanks")
    public List<Vehicle> getVehicles() {
        return vehiclesService.getVehicles();
    }
}
