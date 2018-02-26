package pl.slawek.wotskills.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Vehicle {
    @JsonProperty("nation_i18n")
    private String nation;
    @JsonProperty("level")
    private int level;
    @JsonProperty("type_i18n")
    private String type;
    @JsonProperty("short_name_i18n")
    private String name;
    @JsonProperty("tank_id")
    private int id;
}
