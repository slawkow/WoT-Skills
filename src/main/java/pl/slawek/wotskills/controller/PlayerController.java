package pl.slawek.wotskills.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.slawek.wotskills.model.Player;
import pl.slawek.wotskills.model.PlayerVehicleStats;
import pl.slawek.wotskills.model.dto.PlayerOverallDataDTO;
import pl.slawek.wotskills.service.PlayerService;

import java.util.List;

@RestController
@RequestMapping("/players")
public class PlayerController {

    @Autowired
    private PlayerService playerService;

    @RequestMapping("/{nickname}")
	public List<PlayerVehicleStats> getPlayerTanks(@PathVariable String nickname) {
        Player player = playerService.getPlayer(nickname);
        return playerService.getPlayerVehicleStats(player.getAccountId());
	}

    @RequestMapping("/{nickname}/overall")
    public ResponseEntity<PlayerOverallDataDTO> getPlayerOverallData(@PathVariable String nickname) {
        Player player = playerService.getPlayer(nickname);
        return ResponseEntity.ok(playerService.getPlayerOverallData(player.getAccountId()));
    }
}
