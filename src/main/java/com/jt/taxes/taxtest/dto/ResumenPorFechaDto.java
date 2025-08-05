package com.jt.taxes.taxtest.dto;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class ResumenPorFechaDto {
    private Long numRegistros;
    private Long valorTotal;
}
