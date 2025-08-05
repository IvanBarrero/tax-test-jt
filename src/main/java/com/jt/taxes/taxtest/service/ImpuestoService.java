package com.jt.taxes.taxtest.service;

import com.jt.taxes.taxtest.dto.ImpuestoDto;
import com.jt.taxes.taxtest.dto.ResumenPorFechaDto;

import java.time.LocalDate;
import java.util.List;

public interface ImpuestoService {
    public List<ImpuestoDto> getMovimientosPorFecha(LocalDate date);

    public ResumenPorFechaDto getResumenPorFecha(LocalDate fecha, Character tipoHorario);
}
