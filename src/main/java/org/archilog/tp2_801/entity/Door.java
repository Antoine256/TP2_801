package org.archilog.tp2_801.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.archilog.tp2_801.repository.GenericRepository;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Door implements GenericEntity<Door> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String number;

    @OneToOne
    private Sensor sensor;

    @OneToOne
    private BadgeReader insideReader;

    @OneToOne
    private BadgeReader outsideReader;

    @ManyToOne
    private Batiment batiment;



    @Override
    public void update(Door door) {

    }
}
