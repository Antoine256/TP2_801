package org.archilog.tp2_801.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.archilog.tp2_801.entity.BadgeState;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class BadgeCreateDTO {

    Long id;

    private List<Long> batiments;

    private BadgeState state;

    private Long owner_id;
}
