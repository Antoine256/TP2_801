package org.archilog.tp2_801.controller;

import org.archilog.tp2_801.entity.Intervenant;
import org.archilog.tp2_801.repository.GenericRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/api/intervenant")
public class IntervenantController extends GenericController<Intervenant>{
    public IntervenantController(GenericRepository<Intervenant> repository) {
        super(repository);
    }
}
