package com.jt.taxes.taxtest.controller;

import com.jt.taxes.taxtest.dto.FechaMovimientoDto;
import com.jt.taxes.taxtest.dto.ImpuestoDto;
import com.jt.taxes.taxtest.service.ImpuestoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

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
        System.out.println(fecha.getFecha());
        List<ImpuestoDto> movimientos = service.getMovimientosPorFecha(fecha.getFecha());
        System.out.println(movimientos);
        model.addAttribute("movimientos", movimientos);
        return "movimientos_por_fecha";
    }

    @GetMapping("/movimientos")
    public String selectMovementDate(Model model) {
        FechaMovimientoDto fechaMovimientoDto = new FechaMovimientoDto();
        model.addAttribute("fecha", fechaMovimientoDto);
        return "select_fecha_movimiento";
    }
}
