package pl.slawek.wotskills.model.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PlayerStatsContainerDTO {
    private PlayerStatsDTO all;
}
