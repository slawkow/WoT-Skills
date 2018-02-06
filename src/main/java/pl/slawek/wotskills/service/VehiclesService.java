package pl.slawek.wotskills.service;

import org.springframework.stereotype.Service;
import pl.slawek.wotskills.common.JsonReader;
import pl.slawek.wotskills.model.Vehicle;

import java.util.List;

@Service
public class VehiclesService {
    public List<Vehicle> getVehicles() {
        return JsonReader.getVehicles();
    }
}
