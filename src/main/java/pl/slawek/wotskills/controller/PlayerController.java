package pl.slawek.wotskills.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.slawek.wotskills.model.Player;
import pl.slawek.wotskills.model.dto.PlayerDataDTO;
import pl.slawek.wotskills.service.PlayerService;

@RestController
@RequestMapping("/players")
public class PlayerController {

    @Autowired
    private PlayerService playerService;

    @RequestMapping("/{nickname}")
    public ResponseEntity<PlayerDataDTO> getPlayerOverallData(@PathVariable String nickname) {
        Player player = playerService.getPlayer(nickname);
        return ResponseEntity.ok(playerService.getPlayerOverallData(player.getAccountId()));
    }
}
