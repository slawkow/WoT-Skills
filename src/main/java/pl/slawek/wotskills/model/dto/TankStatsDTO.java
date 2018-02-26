package pl.slawek.wotskills.model.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TankStatsDTO {
    private String tankName;
    private double avgDmg;
    private double avgXP;
    private int battles;
    private double winRatio;
    private int maxXP;
    private int maxFrags;
    private int mastery;
    private double fragsRatio;
    private double spotRatio;
}
