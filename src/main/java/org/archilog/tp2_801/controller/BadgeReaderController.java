package org.archilog.tp2_801.controller;

import lombok.AllArgsConstructor;
import org.archilog.tp2_801.entity.BadgeReader;
import org.archilog.tp2_801.repository.GenericRepository;
import org.archilog.tp2_801.test.EntityProcessor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/api/badge-reader")
public class BadgeReaderController extends GenericController<BadgeReader>{

    public BadgeReaderController(GenericRepository<BadgeReader> repository, EntityProcessor entityProcessor) {
        super(repository, entityProcessor);
    }
}
