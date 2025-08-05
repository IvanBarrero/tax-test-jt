package com.jt.taxes.taxtest.dto;

import lombok.*;

import java.time.LocalDate;

public class ResumenPorFechaDto {
    private Long numRegistros;
    private Long valorTotal;

    public ResumenPorFechaDto(Long numRegistros, Long valorTotal) {
        this.numRegistros = numRegistros;
        this.valorTotal = valorTotal;
    }

    public Long getNumRegistros() {
        return numRegistros;
    }

    public void setNumRegistros(Long numRegistros) {
        this.numRegistros = numRegistros;
    }

    public Long getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Long valorTotal) {
        this.valorTotal = valorTotal;
    }
}
