package org.archilog.tp2_801.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.archilog.tp2_801.entity.BadgeState;
import org.archilog.tp2_801.entity.Batiment;
import org.archilog.tp2_801.entity.Intervenant;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BadgeDTO {
    private Long id;
    private List<Batiment> batiments;
    private BadgeState state;
    private Intervenant owner;
}
