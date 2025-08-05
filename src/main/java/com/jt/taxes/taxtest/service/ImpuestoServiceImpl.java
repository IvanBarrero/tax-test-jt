package com.jt.taxes.taxtest.service;

import com.jt.taxes.taxtest.dto.ImpuestoDto;
import com.jt.taxes.taxtest.dto.ImpuestoMapper;
import com.jt.taxes.taxtest.reposiroty.ImpuestoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

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
}
