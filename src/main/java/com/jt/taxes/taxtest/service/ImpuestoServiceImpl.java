package com.jt.taxes.taxtest.service;

import com.jt.taxes.taxtest.dto.ImpuestoDto;
import com.jt.taxes.taxtest.dto.ImpuestoMapper;
import com.jt.taxes.taxtest.dto.ResumenPorFechaDto;
import com.jt.taxes.taxtest.entity.Impuesto;
import com.jt.taxes.taxtest.reposiroty.ImpuestoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ImpuestoServiceImpl implements ImpuestoService {
    private final ImpuestoRepository repository;

    @Autowired
    public ImpuestoServiceImpl(ImpuestoRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<ImpuestoDto> getMovimientosPorFecha(LocalDate date) {
        return repository.findByFechaMovimiento(date).stream().map(ImpuestoMapper::mapImpuestoToImpuestoDto).toList();
    }

    @Override
    public ResumenPorFechaDto getResumenPorFecha(LocalDate fecha, Character tipoHorario) {
        return repository.findResumenPorFechaDtoByFechaMovimientoAndTipoHorario(fecha, tipoHorario);
    }

    @Override
    public Optional<ImpuestoDto> getImpuestoPorSticker(Long sticker) {
        Optional<Impuesto> impuestoOptional = repository.findById(sticker);
        if(impuestoOptional.isPresent())
            return Optional.of(ImpuestoMapper.mapImpuestoToImpuestoDto(impuestoOptional.get()));
        else
            return Optional.empty();

    }
}
