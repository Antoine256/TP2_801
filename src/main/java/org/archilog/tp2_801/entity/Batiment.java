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
public class Batiment implements GenericEntity<Batiment>{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Long nb_door;


    @ManyToMany
    @JoinTable(name = "badge_batiment",
            joinColumns = @JoinColumn(name = "batiment_id"),
            inverseJoinColumns = @JoinColumn(name = "badges_id"))
    private List<Badge> badges;

    @Override
    public void update(Batiment batiment) {
        this.name = batiment.name;
    }
}
