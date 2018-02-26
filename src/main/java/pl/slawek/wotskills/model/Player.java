package pl.slawek.wotskills.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Player {
    private String nickname;
    @JsonProperty("account_id")
    private long accountId;
}
