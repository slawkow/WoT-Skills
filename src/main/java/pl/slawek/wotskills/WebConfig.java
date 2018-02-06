package pl.slawek.wotskills;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import pl.slawek.wotskills.service.VehiclesService;

@Configuration
@ComponentScan
@EnableWebMvc
public class WebConfig extends WebMvcConfigurerAdapter {

    @Bean
    public VehiclesService vehiclesService() {
        return new VehiclesService();
    }
}