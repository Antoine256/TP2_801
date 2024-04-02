package org.archilog.tp2_801.controller;

import org.archilog.tp2_801.entity.Event;
import org.archilog.tp2_801.repository.EventRepository;
import org.archilog.tp2_801.repository.GenericRepository;
import org.archilog.tp2_801.service.EventService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public class EventController extends GenericController<Event>{

    private final EventService service;

    public EventController(GenericRepository<Event> repository, EventRepository eventRepository) {
        super(repository);
        this.service = new EventService(eventRepository);
    }

    @GetMapping("/searchBat")
    public ResponseEntity<List<Event>> searchBat(@PathVariable String id){
        List<Event> res = service.searchByBat(id);
        return ResponseEntity.ok(res);
    }

    @GetMapping("/searchInt")
    public ResponseEntity<List<Event>> searchInt(@PathVariable String id){
        List<Event> res = service.searchByInt(id);
        return ResponseEntity.ok(res);
    }

}
