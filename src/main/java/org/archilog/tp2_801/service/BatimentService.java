package org.archilog.tp2_801.service;

import org.archilog.tp2_801.entity.Batiment;
import org.archilog.tp2_801.repository.BatimentRepository;

public class BatimentService{

    private final BatimentRepository repository;

    public BatimentService(BatimentRepository repository) {
        this.repository = repository;
    }

    public Batiment create(String name) {
        Batiment bat = new Batiment();
        bat.setName(name);
        return bat;
    }
}
