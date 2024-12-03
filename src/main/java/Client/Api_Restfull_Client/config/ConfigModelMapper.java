package Client.Api_Restfull_Client.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.modelmapper.ModelMapper;

@Configuration
public class ConfigModelMapper {

    @Bean
    public ModelMapper modalMapper(){
        return new ModelMapper();
    }
}
