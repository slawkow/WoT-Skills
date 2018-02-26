package pl.slawek.wotskills.service;

import org.springframework.stereotype.Service;
import pl.slawek.wotskills.common.JsonReader;
import pl.slawek.wotskills.model.Vehicle;

import java.util.List;

@Service
public class VehiclesService {

    private List<Vehicle> vehicles;

    public List<Vehicle> getVehicles() {
        if (vehicles == null) {
            vehicles = JsonReader.getVehicles();
        }

        return vehicles;
    }
}
