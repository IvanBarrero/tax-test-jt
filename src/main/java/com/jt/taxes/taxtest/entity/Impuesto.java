package com.jt.taxes.taxtest.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "impuestos")
public class Impuesto {
    @Id
    private Long sticker;

    private LocalDate fechaMovimiento;

    private LocalDate fechaRecaudo;

    private Character tipoHorario;

    @Column(name = "nro_id")
    private Long numeroId;

    @Column(name = "nro_form")
    private Long numeroFormulario;

    private Long valor;
}
