package org.archilog.tp2_801.service;

import org.archilog.tp2_801.entity.Intervenant;
import org.archilog.tp2_801.repository.GenericRepository;

public class IntervenantService extends GenericService<Intervenant>{
    public IntervenantService(GenericRepository<Intervenant> repository) {
        super(repository);
    }
}
