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

    private final BadgeRepository badgeRepository;
    private final BatimentRepository batimentRepository;
    private final IntervenantRepository intervenantRepository;

    public BadgeService(BadgeRepository repository, BatimentRepository batRepository, IntervenantRepository intRepository) {
        super(repository);
        this.badgeRepository= repository;
        this.intervenantRepository = intRepository;
        this.batimentRepository = batRepository;
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
        badgeRepository.save(badge);
        return badgeCreateDTO;
    }
}
