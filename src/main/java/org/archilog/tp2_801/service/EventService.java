package org.archilog.tp2_801.service;

import org.archilog.tp2_801.entity.Event;
import org.archilog.tp2_801.repository.EventRepository;

import java.util.List;


public class EventService extends GenericService<Event>{

    private EventRepository eventRepository;

    public EventService(EventRepository repository) {
        super(repository);
        this.eventRepository = repository;
    }

    public List<Event> searchByBat(String id){
        return eventRepository.searchByBat(id);
    }

    public List<Event> searchByInt(String id){
        return eventRepository.searchByInt(id);
    }

}
