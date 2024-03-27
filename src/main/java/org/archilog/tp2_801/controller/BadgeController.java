package org.archilog.tp2_801.controller;

import org.archilog.tp2_801.dto.BadgeCreateDTO;
import org.archilog.tp2_801.entity.Badge;
import org.archilog.tp2_801.repository.BadgeRepository;
import org.archilog.tp2_801.repository.BatimentRepository;
import org.archilog.tp2_801.repository.GenericRepository;
import org.archilog.tp2_801.repository.IntervenantRepository;
import org.archilog.tp2_801.service.BadgeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/badge")
public class BadgeController extends GenericController<Badge>{

    private final BadgeService badgeService;
    public BadgeController(GenericRepository<Badge> repository,
                           BadgeRepository badgeRepository,
                           IntervenantRepository intervenantRepository,
                           BatimentRepository batimentRepository) {
        super(repository);
        this.badgeService = new BadgeService(badgeRepository, batimentRepository, intervenantRepository);
    }

    @PostMapping("/create")
    public ResponseEntity<BadgeCreateDTO> createDTO(@RequestBody BadgeCreateDTO badgeDTO){
        BadgeCreateDTO newBadgeDTO = badgeService.createDTO(badgeDTO);
        return new ResponseEntity<>(newBadgeDTO, HttpStatus.CREATED);
    }
}
