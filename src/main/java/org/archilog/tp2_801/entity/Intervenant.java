package org.archilog.tp2_801.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Optional;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Intervenant implements GenericEntity<Intervenant>{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstname;
    private String lastname;


    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = false)
    private List<Badge> badges;


    @Override
    public void update(Intervenant intervenant) {
        this.firstname = intervenant.firstname;
        this.lastname = intervenant.lastname;
    }

    public void removeBadge(Long idBadge){
        Optional<Badge> b = badges.stream().filter(badge -> badge.getId() == idBadge).findFirst();
        if (b.isPresent()) badges.remove(b);
    }
}
