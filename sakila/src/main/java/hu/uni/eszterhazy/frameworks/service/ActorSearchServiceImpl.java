package hu.uni.eszterhazy.frameworks.service;

import hu.uni.eszterhazy.frameworks.model.Actor;
import hu.uni.eszterhazy.frameworks.dao.ActorRepository;

import java.util.Collection;

public class ActorSearchServiceImpl implements ActorSearchService {

    private ActorRepository actorRepository;

    public ActorSearchServiceImpl(ActorRepository actorRepository) {
        this.actorRepository = actorRepository;
    }

    @Override
    public Collection<Actor> listActors() {
        return (Collection<Actor>) actorRepository.findAll();
    }
}
