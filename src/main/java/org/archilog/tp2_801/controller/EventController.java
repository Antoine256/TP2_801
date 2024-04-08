package org.archilog.tp2_801.controller;

import org.archilog.tp2_801.dto.BadgeCreateDTO;
import org.archilog.tp2_801.dto.EventCreateDTO;
import org.archilog.tp2_801.entity.Event;
import org.archilog.tp2_801.repository.*;
import org.archilog.tp2_801.service.EventService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class EventController extends GenericController<Event>{

    private final EventService service;

    public EventController(GenericRepository<Event> repository, EventRepository eventRepository, BadgeRepository badgeRepository, BatimentRepository batimentRepository, IntervenantRepository intervenantRepository) {
        super(repository);
        this.service = new EventService(eventRepository, intervenantRepository, badgeRepository, batimentRepository);
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

    @PostMapping("/create")
    public ResponseEntity<Boolean> createByDto(@RequestBody EventCreateDTO eventDTO){
        Boolean res = service.createByDto(eventDTO);
        System.out.println("Create EVENT");
        return ResponseEntity.ok(res);
    }

}
