package pl.slawek.wotskills.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PlayerVehicleStats {
    VehicleStats clan;
    @JsonProperty("stronghold_skirmish")
    VehicleStats strongholdSkirmish;
    @JsonProperty("regular_team")
    VehicleStats regularTeam;
    @JsonProperty("account_id")
    long accountId;
    @JsonProperty("max_xp")
    int maxXp;
    VehicleStats company;
    VehicleStats all;
    @JsonProperty("stronghold_defense")
    VehicleStats strongholdDefense;
    @JsonProperty("max_frags")
    int maxFrags;
    VehicleStats team;
    VehicleStats globalmap;
    Integer frags;
    @JsonProperty("mark_of_mastery")
    int markOfMastery;
    @JsonProperty("in_garage")
    Boolean inGarage;
    @JsonProperty("tank_id")
    int tankId;
}
