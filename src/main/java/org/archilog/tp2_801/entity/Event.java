package org.archilog.tp2_801.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Event implements GenericEntity<Event>{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Batiment batiment;

    @ManyToOne
    private Badge badge;

    @ManyToOne
    private Intervenant intervenant;

    private Date hour;

    private boolean goIn;

    @Override
    public void update(Event event) {

    }

}
