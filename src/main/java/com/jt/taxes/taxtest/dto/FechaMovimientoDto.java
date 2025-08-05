package com.jt.taxes.taxtest.dto;

import lombok.*;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class FechaMovimientoDto {
    private LocalDate fecha;
}
