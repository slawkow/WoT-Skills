package pl.slawek.wotskills.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class PlayerStats {
    private int spotted;
    @JsonProperty("max_xp")
    private int maxXP;
    @JsonProperty("avg_damage_blocked")
    private double avgDamageBlocked;
    private long xp;
    @JsonProperty("survived_battles")
    private int survivedBattles;
    @JsonProperty("hits_percents")
    private int hitsPercents;
    private int draws;
    private int battles;
    @JsonProperty("avg_damage_assisted")
    private double avgDamageAssisted;
    private int frags;
    @JsonProperty("max_damage")
    private int maxDamage;
    @JsonProperty("battle_avg_xp")
    private int battleAvgXP;
    private int wins;
    private int losses;
    @JsonProperty("damage_dealt")
    private long damageDealt;
    @JsonProperty("max_frags")
    private int maxFrags;
}
