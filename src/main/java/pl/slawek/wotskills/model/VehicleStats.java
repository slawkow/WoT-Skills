package pl.slawek.wotskills.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class VehicleStats {
    int spotted;
    @JsonProperty("battles_on_stunning_vehicles")
    int battlesOnStunningVehicles;
    @JsonProperty("avg_damage_blocked")
    double avgDamageBlocked;
    @JsonProperty("direct_hits_received")
    int directHitsReceived;
    @JsonProperty("explosion_hits")
    int explosionHits;
    @JsonProperty("piercings_received")
    int piercingsReceived;
    int piercings;
    int xp;
    @JsonProperty("survived_battles")
    int survivedBattles;
    @JsonProperty("dropped_capture_points")
    int droppedCapturePoints;
    @JsonProperty("hits_percents")
    int hitsPercents;
    int draws;
    int battles;
    @JsonProperty("damage_received")
    int damageReceived;
    int frags;
    @JsonProperty("stun_number")
    int stunNumber;
    @JsonProperty("capture_points")
    int capturePoints;
    @JsonProperty("stun_assisted_damage")
    int stunAssistedDamage;
    int hits;
    @JsonProperty("battle_avg_xp")
    int battleAvgXp;
    int wins;
    int losses;
    @JsonProperty("damage_dealt")
    int damageDealt;
    @JsonProperty("no_damage_direct_hits_received")
    int noDamageDirectHitsReceived;
    int shots;
    @JsonProperty("explosion_hits_received")
    int explosionHitsReceived;
    @JsonProperty("tanking_factor")
    double tankingFactor;
    @JsonProperty("max_xp")
    int maxXp;
    @JsonProperty("max_damage")
    int maxDamage;
    @JsonProperty("max_frags")
    int maxFrags;
    @JsonProperty("avg_damage_assisted")
    double avgDamageAssisted;
    @JsonProperty("avg_damage_assisted_track")
    double avgDamageAssistedTrack;
    @JsonProperty("avg_damage_assisted_radio")
    double avgDamageAssistedRadio;
}
