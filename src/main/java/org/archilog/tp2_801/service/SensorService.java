package org.archilog.tp2_801.service;

import org.archilog.tp2_801.entity.Sensor;
import org.archilog.tp2_801.repository.GenericRepository;

public class SensorService extends GenericService<Sensor>{
    public SensorService(GenericRepository<Sensor> repository) {
        super(repository);
    }
}
