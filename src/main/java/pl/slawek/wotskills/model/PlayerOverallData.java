package pl.slawek.wotskills.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class PlayerOverallData {
    @JsonProperty("last_battle_time")
    private long lastBattleTime;
    @JsonProperty("created_at")
    private long createdAt;
    @JsonProperty("updated_at")
    private long updatedAt;
    @JsonProperty("global_rating")
    private int globalRating;
    @JsonProperty("logout_at")
    private long logoutAt;
    private PlayerStatsContainer statistics;
}
