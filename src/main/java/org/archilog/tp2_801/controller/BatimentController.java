package org.archilog.tp2_801.controller;


import org.archilog.tp2_801.entity.Batiment;
import org.archilog.tp2_801.repository.GenericRepository;
import org.archilog.tp2_801.test.EntityProcessor;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/batiment")
public class BatimentController extends GenericController<Batiment>{

    public BatimentController(GenericRepository<Batiment> repository, EntityProcessor entityProcessor) {
        super(repository, entityProcessor);
    }
}
