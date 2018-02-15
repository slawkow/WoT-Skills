package pl.slawek.wotskills.service;

import org.springframework.stereotype.Service;
import pl.slawek.wotskills.common.JsonReader;
import pl.slawek.wotskills.model.Player;
import pl.slawek.wotskills.model.PlayerVehicleStats;

import java.util.List;

@Service
public class PlayerService {

    public Player getPlayer(String nickname) {
        return JsonReader.getPlayerAccount(nickname);
    }

    public List<PlayerVehicleStats> getPlayerVehicleStats(long accountID) {
        return JsonReader.getPlayerVehicleStats(accountID);
    }
}
