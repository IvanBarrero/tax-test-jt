package com.jt.taxes.taxtest.dto;

import com.jt.taxes.taxtest.entity.Impuesto;

public class ImpuestoMapper {
    public static ImpuestoDto mapImpuestoToImpuestoDto(Impuesto impuesto) {
        ImpuestoDto impuestoDto = new ImpuestoDto();
        impuestoDto.setSticker(impuesto.getSticker());
        impuestoDto.setFechaMovimiento(impuesto.getFechaMovimiento());
        impuestoDto.setFechaRecaudo(impuesto.getFechaRecaudo());
        impuestoDto.setTipoHorario(impuesto.getTipoHorario());
        impuestoDto.setValor(impuesto.getValor());
        impuestoDto.setNumeroId(impuesto.getNumeroId());
        impuestoDto.setNumeroFormulario(impuesto.getNumeroFormulario());
        return  impuestoDto;
    }

    public static Impuesto mapImpuestoDtoToImpuesto(ImpuestoDto impuestoDto) {
        Impuesto impuesto = new Impuesto();
        impuesto.setSticker(impuestoDto.getSticker());
        impuesto.setFechaMovimiento(impuestoDto.getFechaMovimiento());
        impuesto.setFechaRecaudo(impuestoDto.getFechaRecaudo());
        impuesto.setTipoHorario(impuestoDto.getTipoHorario());
        impuesto.setValor(impuestoDto.getValor());
        impuesto.setNumeroId(impuestoDto.getNumeroId());
        impuesto.setNumeroFormulario(impuestoDto.getNumeroFormulario());
        return  impuesto;
    }
}
