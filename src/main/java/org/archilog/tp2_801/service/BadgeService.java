package org.archilog.tp2_801.service;

import org.archilog.tp2_801.dto.BadgeCreateDTO;
import org.archilog.tp2_801.entity.Badge;
import org.archilog.tp2_801.entity.Batiment;
import org.archilog.tp2_801.entity.Intervenant;
import org.archilog.tp2_801.repository.BadgeRepository;
import org.archilog.tp2_801.repository.BatimentRepository;
import org.archilog.tp2_801.repository.GenericRepository;
import org.archilog.tp2_801.repository.IntervenantRepository;

import java.util.List;

public class BadgeService extends GenericService<Badge>{

    private BadgeRepository badgeRepository = null;
    private BatimentRepository batimentRepository = null;
    private IntervenantRepository intervenantRepository = null;

    public BadgeService(BadgeRepository repository, BatimentRepository batRepository, IntervenantRepository intRepository) {
        super(repository);
        this.badgeRepository= repository;
        this.intervenantRepository = intRepository;
        this.batimentRepository = batRepository;
    }

    public BadgeService(BadgeRepository badgeRepository) {
        super(badgeRepository);
        this.badgeRepository = badgeRepository;
    }


    public BadgeCreateDTO createDTO(BadgeCreateDTO badgeCreateDTO){
        Badge badge = new Badge();

        Intervenant intervenant = intervenantRepository.findById(badgeCreateDTO.getOwner_id())
                .orElseThrow(() -> new RuntimeException("Intervenant not found with id: " + badgeCreateDTO.getOwner_id()));

        List<Badge> badges = intervenant.getBadges();

        List<Batiment> batiments = batimentRepository.findAllById(badgeCreateDTO.getBatiments());

        badge.setState(badgeCreateDTO.getState());
        badge.setBatiments(batiments);
        badge.setOwner(intervenant);
        Badge newBadge = badgeRepository.save(badge);
        badges.add(newBadge);
        intervenant.setBadges(badges);
        intervenantRepository.save(intervenant);
        badgeCreateDTO.setId(newBadge.getId());
        return badgeCreateDTO;
    }

    public BadgeCreateDTO updateDTO(BadgeCreateDTO badgeCreateDTO){
        Badge badge = new Badge();

        Intervenant intervenant = intervenantRepository.findById(badgeCreateDTO.getOwner_id())
                .orElseThrow(() -> new RuntimeException("Intervenant not found with id: " + badgeCreateDTO.getOwner_id()));

        List<Batiment> batiments = batimentRepository.findAllById(badgeCreateDTO.getBatiments());

        badge.setId(badgeCreateDTO.getId());
        badge.setState(badgeCreateDTO.getState());
        badge.setBatiments(batiments);
        badge.setOwner(intervenant);
        intervenant.removeBadge(badgeCreateDTO.getId());
        badgeRepository.save(badge);
        return badgeCreateDTO;
    }

    public Boolean canAccess(Long badgeId, Long batId){
        Badge badge = badgeRepository.findById(badgeId).orElseThrow();
        return badge.canAccess(batId);
    }
}
