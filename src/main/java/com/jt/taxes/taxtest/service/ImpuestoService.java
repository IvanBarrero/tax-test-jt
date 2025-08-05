package com.jt.taxes.taxtest.service;

import com.jt.taxes.taxtest.dto.ImpuestoDto;

import java.time.LocalDate;
import java.util.List;

public interface ImpuestoService {
    public List<ImpuestoDto> getMovimientosPorFecha(LocalDate date);
}
