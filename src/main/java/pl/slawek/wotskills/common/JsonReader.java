package pl.slawek.wotskills.common;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import pl.slawek.wotskills.model.Player;
import pl.slawek.wotskills.model.PlayerVehicleStats;
import pl.slawek.wotskills.model.Vehicle;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class JsonReader {

    private static ObjectMapper mapper;

    public static Player getPlayerAccount(String nickname) {
        HashMap<String, String> parameters = new HashMap<String, String>() {{
            put("type", "exact");
            put("search", nickname);
        }};

        URL url = URLBuilder.getURL("account/list/", parameters);
        mapper = new ObjectMapper();

        JsonNode playerDataNode = getJsonTree(url).get("data");
        List<Player> players = null;

        try {
            players = Arrays.asList(mapper.treeToValue(playerDataNode, Player[].class));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        if (players != null && players.size() > 0)
            return players.get(0);
        else {
            throw new IllegalArgumentException("Nickname: " + nickname + " has not been found.");
        }
    }

    public static List<PlayerVehicleStats> getPlayerVehicleStats(long accountID) {
        HashMap<String, String> parameters = new HashMap<String, String>() {{
            put("account_id", String.valueOf(accountID));
        }};

        URL url = URLBuilder.getURL("/tanks/stats/", parameters);
        mapper = new ObjectMapper();
        JsonNode playerVehicles = getJsonTree(url).get("data").get(String.valueOf(accountID));

        List<PlayerVehicleStats> playerVehicleStats = null;
        try {
            playerVehicleStats = Arrays.asList(mapper.treeToValue(playerVehicles, PlayerVehicleStats[].class));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return playerVehicleStats;
    }

    public static List<Vehicle> getVehicles() {
        URL url = URLBuilder.getURL("/encyclopedia/tanks/", null);
        mapper = new ObjectMapper();
        JsonNode vehicles = getJsonTree(url).get("data");

        final List<Vehicle> vehiclesList = new ArrayList<>();
        vehicles.forEach(vehicle -> {
            try {
                vehiclesList.add(mapper.treeToValue(vehicle, Vehicle.class));
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        });

        return vehiclesList;
    }

    private static JsonNode getJsonTree(URL url) {
        JsonNode tree = null;
        try {
            tree = mapper.readTree(url);
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (tree != null) {
            return tree;
        } else {
            throw new RuntimeException("JSON tree has not been read correctly.");
        }
    }
}
