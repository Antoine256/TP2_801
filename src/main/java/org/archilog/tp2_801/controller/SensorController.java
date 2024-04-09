package org.archilog.tp2_801.controller;

import org.archilog.tp2_801.entity.Sensor;
import org.archilog.tp2_801.repository.GenericRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/api/sensor")
public class SensorController extends GenericController<Sensor>{

    public SensorController(GenericRepository<Sensor> repository) {
        super(repository);
    }
}
