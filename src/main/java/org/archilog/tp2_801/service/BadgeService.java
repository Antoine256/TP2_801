package org.archilog.tp2_801.service;

import org.archilog.tp2_801.dto.BadgeCreateDTO;
import org.archilog.tp2_801.entity.Badge;
import org.archilog.tp2_801.repository.BadgeRepository;
import org.archilog.tp2_801.repository.GenericRepository;

public class BadgeService extends GenericService<Badge>{

    private BadgeRepository badgeRepository;

    public BadgeService(GenericRepository<Badge> repository) {
        super(repository);
        this.badgeRepository= (BadgeRepository) repository;
    }


    public BadgeCreateDTO createDTO(BadgeCreateDTO badgeCreateDTO){
        
    }


}
