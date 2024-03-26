package org.archilog.tp2_801.controller;

import lombok.AllArgsConstructor;
import org.archilog.tp2_801.entity.Door;
import org.archilog.tp2_801.repository.GenericRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/api/door")
public class DoorController  extends GenericController<Door>{


    public DoorController(GenericRepository<Door> repository) {
        super(repository);
    }
}
