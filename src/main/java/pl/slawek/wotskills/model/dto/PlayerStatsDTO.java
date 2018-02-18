package pl.slawek.wotskills.model.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PlayerStatsDTO {
    private double avgSpotted;
    private double avgDamageBlocked;
    private double avgDamageAssisted;
    private double avgDamage;
    private int maxDamage;
    private double survivedBattlesPercents;
    private int hitsPercents;
    private int battles;
    private int draws;
    private int wins;
    private int losses;
    private double winRatio;
    private double loseRatio;
    private double drawRatio;
    private int frags;
    private double avgFrags;
    private int maxFrags;
    private int maxXP;
    private int avgXP;
}
