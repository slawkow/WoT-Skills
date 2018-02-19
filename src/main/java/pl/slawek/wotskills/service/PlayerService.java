package pl.slawek.wotskills.service;

import org.springframework.stereotype.Service;
import pl.slawek.wotskills.common.DataUtil;
import pl.slawek.wotskills.common.JsonReader;
import pl.slawek.wotskills.model.Player;
import pl.slawek.wotskills.model.PlayerOverallData;
import pl.slawek.wotskills.model.PlayerStats;
import pl.slawek.wotskills.model.PlayerVehicleStats;
import pl.slawek.wotskills.model.dto.PlayerDataDTO;
import pl.slawek.wotskills.model.dto.PlayerStatsContainerDTO;
import pl.slawek.wotskills.model.dto.PlayerStatsDTO;
import pl.slawek.wotskills.model.dto.TankStatsDTO;

import java.util.ArrayList;
import java.util.List;

@Service
public class PlayerService {

    public Player getPlayer(String nickname) {
        return JsonReader.getPlayerAccount(nickname);
    }

    public List<PlayerVehicleStats> getPlayerVehicleStats(long accountID) {
        return JsonReader.getPlayerVehicleStats(accountID);
    }

    public PlayerDataDTO getPlayerOverallData(long accountID) {
        PlayerOverallData playerOverallData = JsonReader.getPlayerOverallData(accountID);

        String createdAt = DataUtil.getDataFromTimestamp(playerOverallData.getCreatedAt());
        String logoutAt = DataUtil.getDataFromTimestamp(playerOverallData.getLogoutAt());
        String updatedAt = DataUtil.getDataFromTimestamp(playerOverallData.getUpdatedAt());
        String lastBattleTime = DataUtil.getDataFromTimestamp(playerOverallData.getLastBattleTime());

        PlayerStatsContainerDTO playerStatsContainer = PlayerStatsContainerDTO.builder()
                .all(getPlayerStatsFromData(playerOverallData))
                .build();

        List<TankStatsDTO> tanksStats = getTanksStats(accountID);

        PlayerDataDTO playerDataDTO = PlayerDataDTO.builder()
                .createdAt(createdAt)
                .globalRating(playerOverallData.getGlobalRating())
                .lastBattleTime(lastBattleTime)
                .logoutAt(logoutAt)
                .statistics(playerStatsContainer)
                .updatedAt(updatedAt)
                .tanks(tanksStats)
                .build();

        return playerDataDTO;
    }

    private List<TankStatsDTO> getTanksStats(long accountID) {
        List<PlayerVehicleStats> playerVehicleStatsList = getPlayerVehicleStats(accountID);
        List<TankStatsDTO> tanksStats = new ArrayList<>();

        for (PlayerVehicleStats playerVehicleStats : playerVehicleStatsList) {
            int battles = playerVehicleStats.getAll().getBattles();
            double avgDmg = getRoundedValue((double) playerVehicleStats.getAll().getDamageDealt() / battles);
            double fragsRatio = getRoundedValue((double) playerVehicleStats.getAll().getFrags() / battles);
            double spotRatio = getRoundedValue((double) playerVehicleStats.getAll().getSpotted() / battles);
            double winRatio = getRoundedValue((double) playerVehicleStats.getAll().getWins() / battles);

            TankStatsDTO tankStatsDTO = TankStatsDTO.builder()
                    .avgDmg(avgDmg)
                    .avgXP(playerVehicleStats.getAll().getBattleAvgXp())
                    .battles(playerVehicleStats.getAll().getBattles())
                    .fragsRatio(fragsRatio)
                    .mastery(playerVehicleStats.getMarkOfMastery())
                    .maxFrags(playerVehicleStats.getMaxFrags())
                    .maxXP(playerVehicleStats.getMaxXp())
                    .spotRatio(spotRatio)
                    .tankName(String.valueOf(playerVehicleStats.getTankId()))
                    .winRatio(winRatio)
                    .build();

            tanksStats.add(tankStatsDTO);
        }

        return tanksStats;
    }

    private PlayerStatsDTO getPlayerStatsFromData(PlayerOverallData playerOverallData) {
        //TODO do it for another stats possibilites (distribute .getAll())
        PlayerStats playerStats = playerOverallData.getStatistics().getAll();

        double avgDamage = getRoundedValue((double) playerStats.getDamageDealt() / playerStats.getBattles());
        double avgSpotted = getRoundedValue((double) playerStats.getSpotted() / playerStats.getBattles());
        double avgFrags = getRoundedValue((double) playerStats.getFrags() / playerStats.getBattles());
        double drawRatio = getRoundedValue((double) playerStats.getDraws() / playerStats.getBattles());
        double loseRatio = getRoundedValue((double) playerStats.getLosses() / playerStats.getBattles());
        double winRatio = getRoundedValue((double) playerStats.getWins() / playerStats.getBattles());
        double survivedBattlesPercent = getRoundedValue((double) playerStats.getSurvivedBattles() / playerStats.getBattles());

        PlayerStatsDTO playerStatsDTO = PlayerStatsDTO.builder()
                .avgDamage(avgDamage)
                .avgDamageAssisted(playerStats.getAvgDamageAssisted())
                .avgDamageBlocked(playerStats.getAvgDamageBlocked())
                .avgFrags(avgFrags)
                .avgSpotted(avgSpotted)
                .avgXP(playerStats.getBattleAvgXP())
                .battles(playerStats.getBattles())
                .drawRatio(drawRatio)
                .draws(playerStats.getDraws())
                .frags(playerStats.getFrags())
                .hitsPercents(playerStats.getHitsPercents())
                .loseRatio(loseRatio)
                .losses(playerStats.getLosses())
                .maxDamage(playerStats.getMaxDamage())
                .maxFrags(playerStats.getMaxFrags())
                .maxXP(playerStats.getMaxXP())
                .survivedBattlesPercents(survivedBattlesPercent)
                .winRatio(winRatio)
                .wins(playerStats.getWins())
                .build();

        return playerStatsDTO;
    }

    private double getRoundedValue(double value) {
        return (double) Math.round(value * 100d) / 100d;
    }
}
