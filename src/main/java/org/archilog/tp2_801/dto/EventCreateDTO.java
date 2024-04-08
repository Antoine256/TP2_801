package org.archilog.tp2_801.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
public class EventCreateDTO {

    private Long idBatiment;

    private Long idBadge;

    private boolean goIn;

}
