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
public class Intervenant implements GenericEntity<Intervenant>{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstname;
    private String lastname;
    @OneToMany
    private List<Badge> badges;


    @Override
    public void update(Intervenant intervenant) {
        this.firstname = intervenant.firstname;
        this.lastname = intervenant.lastname;
    }
}
