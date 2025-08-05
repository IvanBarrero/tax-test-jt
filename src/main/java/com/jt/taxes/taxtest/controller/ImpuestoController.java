package com.jt.taxes.taxtest.controller;

import com.jt.taxes.taxtest.dto.FechaMovimientoDto;
import com.jt.taxes.taxtest.dto.ImpuestoDto;
import com.jt.taxes.taxtest.dto.ResumenPorFechaDto;
import com.jt.taxes.taxtest.dto.StickerDto;
import com.jt.taxes.taxtest.service.ImpuestoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/impuestos")
public class ImpuestoController {
    private final ImpuestoService service;

    @Autowired
    public ImpuestoController(ImpuestoService service) {
        this.service = service;
    }

    @PostMapping("/movimientosPorFecha")
    public String listMovementPerDate(@ModelAttribute("fecha") FechaMovimientoDto fecha, Model model) {
        List<ImpuestoDto> movimientos = service.getMovimientosPorFecha(fecha.getFecha());
        model.addAttribute("movimientos", movimientos);

        ResumenPorFechaDto resumenTipoA = service.getResumenPorFecha(fecha.getFecha(), 'A');
        model.addAttribute("resumenTipoA", resumenTipoA);

        ResumenPorFechaDto resumenTipoN = service.getResumenPorFecha(fecha.getFecha(), 'N');
        model.addAttribute("resumenTipoN", resumenTipoN);

        return "movimientos_por_fecha";
    }

    @GetMapping("/movimientos")
    public String selectMovementDate(Model model) {
        FechaMovimientoDto fechaMovimientoDto = new FechaMovimientoDto();
        model.addAttribute("fecha", fechaMovimientoDto);
        return "select_fecha_movimiento";
    }

    @GetMapping("/stickers")
    public String selectSticker(Model model) {
        StickerDto stickerDto = new StickerDto();
        model.addAttribute("sticker", stickerDto);
        return "select_sticker_movimiento";
    }

    @PostMapping("/movimientoPorSticker")
    public String listMovementPerSticker(@ModelAttribute("sticker") StickerDto stickerDto, Model model) {
        Optional<ImpuestoDto> impuestoDtoOptional = service.getImpuestoPorSticker(stickerDto.getSticker());

        model.addAttribute("movimiento", impuestoDtoOptional);

        return "movimiento_por_sticker";
    }
}
