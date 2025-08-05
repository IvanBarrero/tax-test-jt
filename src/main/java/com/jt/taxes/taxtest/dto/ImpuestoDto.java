package com.jt.taxes.taxtest.dto;

import lombok.*;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class ImpuestoDto {
    private Long sticker;

    private LocalDate fechaMovimiento;

    private LocalDate fechaRecaudo;

    private Character tipoHorario;

    private Long numeroId;

    private Long numeroFormulario;

    private Long valor;
}
