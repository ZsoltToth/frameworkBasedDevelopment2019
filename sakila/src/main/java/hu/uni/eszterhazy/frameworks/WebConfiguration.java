package hu.uni.eszterhazy.frameworks;

import hu.uni.eszterhazy.frameworks.dao.ActorRepository;
import hu.uni.eszterhazy.frameworks.service.ActorSearchService;
import hu.uni.eszterhazy.frameworks.service.ActorSearchServiceImpl;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;

@SpringBootConfiguration
public class WebConfiguration {

    @Bean
    public ActorSearchService actorSearchService(ActorRepository actorRepository){
        return new ActorSearchServiceImpl(actorRepository);
    }
}
