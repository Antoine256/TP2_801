package org.archilog.tp2_801.repository;

import org.archilog.tp2_801.entity.Event;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EventRepository extends GenericRepository<Event>{

    @Query(value = "SELECT * FROM Event e WHERE e.batiment.id = ?1", nativeQuery = true)
    List<Event> searchByBat(String id);

    @Query(value = "SELECT * FROM Event e WHERE e.intervenant.id = ?1", nativeQuery = true)
    List<Event> searchByInt(String id);
}
