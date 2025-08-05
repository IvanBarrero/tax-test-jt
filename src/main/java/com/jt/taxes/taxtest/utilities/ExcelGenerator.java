package com.jt.taxes.taxtest.utilities;

import com.jt.taxes.taxtest.dto.ImpuestoDto;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class ExcelGenerator {
    public byte[] generateExcel(ImpuestoDto impuestoDto) throws IOException {
        try (Workbook workbook = new XSSFWorkbook()) {
            Sheet sheet = workbook.createSheet("Movimiento");

            CreationHelper createHelper = workbook.getCreationHelper();
            CellStyle dateCellStyle = workbook.createCellStyle();
            dateCellStyle.setDataFormat(createHelper.createDataFormat().getFormat("yyyyMMdd"));

            // Create header row
            Row headerRow = sheet.createRow(0);
            headerRow.createCell(0).setCellValue("Sticker");
            headerRow.createCell(1).setCellValue("Fecha de Movimiento");
            headerRow.createCell(2).setCellValue("Tipo de Horario");
            headerRow.createCell(3).setCellValue("Fecha de Recaudo");
            headerRow.createCell(4).setCellValue("Numero de Identificacion");
            headerRow.createCell(5).setCellValue("Numero de Formulario");
            headerRow.createCell(6).setCellValue("Valor");

            // Populate data rows
            Row dataRow = sheet.createRow(1);
            dataRow.createCell(0).setCellValue(impuestoDto.getSticker());
            dataRow.createCell(1).setCellValue(impuestoDto.getFechaMovimiento().toString());
            dataRow.createCell(2).setCellValue(impuestoDto.getTipoHorario().toString());
            dataRow.createCell(3).setCellValue(impuestoDto.getFechaRecaudo().toString());
            dataRow.createCell(4).setCellValue(impuestoDto.getNumeroId());
            dataRow.createCell(5).setCellValue(impuestoDto.getNumeroFormulario());
            dataRow.createCell(6).setCellValue(impuestoDto.getValor());

            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            workbook.write(outputStream);
            return outputStream.toByteArray();
        }
    }
}
