package pl.slawek.wotskills.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.slawek.wotskills.model.Vehicle;
import pl.slawek.wotskills.service.VehiclesService;

import java.util.List;

@RestController
@RequestMapping("/tanks")
public class VehicleController {
    private VehiclesService vehiclesService;

    @Autowired
    public VehicleController(VehiclesService vehiclesService) {
        this.vehiclesService = vehiclesService;
    }

    @RequestMapping("/all")
    public List<Vehicle> getVehicles() {
        return vehiclesService.getVehicles();
    }
}
