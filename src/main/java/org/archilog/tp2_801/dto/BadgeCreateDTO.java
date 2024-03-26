package org.archilog.tp2_801.dto;

import org.archilog.tp2_801.entity.BadgeState;

import java.util.List;

public class BadgeCreateDTO {
    private List<Long> batiments_id;

    private BadgeState state;

    private Long owner_id;
}
