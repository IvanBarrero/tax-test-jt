package com.jt.taxes.taxtest.dto;

import lombok.*;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class ResumenPorFechaDto {
    private LocalDate fechaMovimiento;

    private Character tipoHorario;

    private Integer numRegistros;

    private Long valorTotal;
}
