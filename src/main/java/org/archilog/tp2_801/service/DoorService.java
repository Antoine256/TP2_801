package org.archilog.tp2_801.service;

import org.archilog.tp2_801.entity.Door;
import org.archilog.tp2_801.repository.GenericRepository;

public class DoorService extends GenericService<Door>{
    public DoorService(GenericRepository<Door> repository) {
        super(repository);
    }
}
