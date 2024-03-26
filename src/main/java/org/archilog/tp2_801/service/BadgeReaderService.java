package org.archilog.tp2_801.service;

import org.archilog.tp2_801.entity.BadgeReader;
import org.archilog.tp2_801.repository.GenericRepository;

public class BadgeReaderService extends GenericService<BadgeReader>{
    public BadgeReaderService(GenericRepository<BadgeReader> repository) {
        super(repository);
    }
}
