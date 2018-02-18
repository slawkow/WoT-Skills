package pl.slawek.wotskills.model.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PlayerOverallDataDTO {
    private String lastBattleTime;
    private String createdAt;
    private String updatedAt;
    private int globalRating;
    private String logoutAt;
    private PlayerStatsContainerDTO statistics;
}
