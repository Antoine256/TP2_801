package org.archilog.tp2_801.controller;

import org.archilog.tp2_801.repository.BadgeRepository;
import org.archilog.tp2_801.service.BadgeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class BaseController {

    private BadgeService badgeService;

    BaseController(BadgeRepository badgeRepository){
        this.badgeService = new BadgeService(badgeRepository);
    }

    @GetMapping("/canAccess")
    public ResponseEntity<Boolean> canAccess(@RequestParam Long idBadge, @RequestParam Long idBatiment ){
        return ResponseEntity.ok(badgeService.canAccess(idBadge, idBatiment));
    }
}
