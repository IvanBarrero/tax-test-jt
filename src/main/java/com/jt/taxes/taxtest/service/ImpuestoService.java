package com.jt.taxes.taxtest.service;

import com.jt.taxes.taxtest.dto.ImpuestoDto;
import com.jt.taxes.taxtest.dto.ResumenPorFechaDto;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface ImpuestoService {
    List<ImpuestoDto> getMovimientosPorFecha(LocalDate date);

    ResumenPorFechaDto getResumenPorFecha(LocalDate fecha, Character tipoHorario);

    Optional<ImpuestoDto> getImpuestoPorSticker(Long sticker);
}
