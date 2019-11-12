package hu.uni.eszterhazy.frameworks;

import hu.uni.eszterhazy.frameworks.model.Actor;
import hu.uni.eszterhazy.frameworks.service.ActorSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;


@RestController
@RequestMapping(value = {"/actor"})
public class ActorsController {

    @Autowired
    private ActorSearchService actorSearchService;



    @RequestMapping(value={"/all"}, method = RequestMethod.GET)
    public Collection<Actor> fetchAllActors(){
        return actorSearchService.listActors();
    }
}
