package org.archilog.tp2_801.service;

import org.archilog.tp2_801.dto.EventCreateDTO;
import org.archilog.tp2_801.entity.Badge;
import org.archilog.tp2_801.entity.Batiment;
import org.archilog.tp2_801.entity.Event;
import org.archilog.tp2_801.entity.Intervenant;
import org.archilog.tp2_801.repository.BadgeRepository;
import org.archilog.tp2_801.repository.BatimentRepository;
import org.archilog.tp2_801.repository.EventRepository;
import org.archilog.tp2_801.repository.IntervenantRepository;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;


public class EventService extends GenericService<Event>{

    private final EventRepository eventRepository;
    private BadgeRepository badgeRepository;
    private BatimentRepository batimentRepository;
    private IntervenantRepository intervenantRepository;

    public EventService(EventRepository repository, IntervenantRepository intervenantRepository, BadgeRepository badgeRepository, BatimentRepository batimentRepository) {
        super(repository);
        this.eventRepository = repository;
    }

    public List<Event> searchByBat(String id){
        return eventRepository.searchByBat(id);
    }

    public List<Event> searchByInt(String id){
        return eventRepository.searchByInt(id);
    }

    public Boolean createByDto(EventCreateDTO eventDTO) {
        Event event = new Event();
        eventRepository.save(event);
        Badge badge = badgeRepository.findById(eventDTO.getIdBadge()).orElseThrow();
        Batiment batiment = batimentRepository.findById(eventDTO.getIdBatiment()).orElseThrow();
        //Intervenant intervenant = intervenantRepository.findById(eventDTO.getIdIntervenant()).orElseThrow();
        event.setBadge(badge);
        event.setBatiment(batiment);
        event.setHour(new Date());
        //event.setIntervenant(intervenant);
        event.setGoIn(eventDTO.isGoIn());
        eventRepository.save(event);
        return true;
    }
}
