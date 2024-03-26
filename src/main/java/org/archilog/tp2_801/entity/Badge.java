package org.archilog.tp2_801.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Badge implements GenericEntity<Badge>{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany
    private List<Batiment> batiments;

    private BadgeState state;

    @ManyToOne
    private Intervenant owner;


    @Override
    public void update(Badge badge) {
        this.owner = badge.owner;
        this.state = badge.state;
    }
}
