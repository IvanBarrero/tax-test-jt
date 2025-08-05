package com.jt.taxes.taxtest.controller;

import com.jt.taxes.taxtest.dto.FechaMovimientoDto;
import com.jt.taxes.taxtest.dto.ImpuestoDto;
import com.jt.taxes.taxtest.dto.ResumenPorFechaDto;
import com.jt.taxes.taxtest.dto.StickerDto;
import com.jt.taxes.taxtest.service.ImpuestoService;
import com.jt.taxes.taxtest.utilities.ExcelGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
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
        impuestoDtoOptional.ifPresent(impuestoDto -> model.addAttribute("impuesto", impuestoDto));

        return "movimiento_por_sticker";
    }

    @PostMapping("/exportarMovimientoAXls")
    public ResponseEntity<byte[]> exportMovementToXls(@RequestParam Long sticker) throws IOException {
        ExcelGenerator generator = new ExcelGenerator();

        Optional<ImpuestoDto> impuestoDtoOptional = service.getImpuestoPorSticker(sticker);
        byte[] excelBytes = generator.generateExcel(impuestoDtoOptional.get());

        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=data.xlsx");
        return ResponseEntity.ok()
                .headers(headers)
                .contentType(MediaType.parseMediaType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"))
                .body(excelBytes);
    }
}
