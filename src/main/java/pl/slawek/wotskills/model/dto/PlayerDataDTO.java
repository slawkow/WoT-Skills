package pl.slawek.wotskills.model.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class PlayerDataDTO {
    private String lastBattleTime;
    private String createdAt;
    private String updatedAt;
    private int globalRating;
    private String logoutAt;
    private PlayerStatsContainerDTO statistics;
    private List<TankStatsDTO> tanks;
}
