package org.archilog.tp2_801.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Objects;

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

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name="owner_id")
    @JsonBackReference
    private Intervenant owner;


    @Override
    public void update(Badge badge) {
        this.owner = badge.owner;
        this.state = badge.state;
    }

    public Boolean canAccess(Long idBatiment){
        for (int i = 0; i < batiments.toArray().length ; i++) {
            if (Objects.equals(idBatiment, batiments.get(i).getId()))return true;
        }
        return false;
    }
}
