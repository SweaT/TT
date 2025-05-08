package com.example.TT.service.impl;

import com.example.TT.service.PdfReportService;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class PdfReportServiceImpl implements PdfReportService {

    @Override
    public byte[] generateReport() throws DocumentException {
        // Создаем документ
        Document document = new Document();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        // Получаем writer для документа
        PdfWriter pdfWriter = PdfWriter.getInstance(document, outputStream);

        // Открываем документ
        document.open();

        // Добавляем содержимое
        Font titleFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 18, BaseColor.BLACK);
        Paragraph title = new Paragraph("Отчет о деятельности", titleFont);
        title.setAlignment(Element.ALIGN_CENTER);
        document.add(title);

        document.add(Chunk.NEWLINE);

        Font subtitleFont = FontFactory.getFont(FontFactory.HELVETICA, 14, BaseColor.DARK_GRAY);
        String dateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss"));
        Paragraph subtitle = new Paragraph("Сгенерировано: " + dateTime, subtitleFont);
        subtitle.setAlignment(Element.ALIGN_CENTER);
        document.add(subtitle);

        document.add(Chunk.NEWLINE);
        document.add(Chunk.NEWLINE);

        // Добавляем таблицу с данными
        PdfPTable table = new PdfPTable(3);
        table.setWidthPercentage(100);

        // Заголовки таблицы
        table.addCell(createCell("ID", true));
        table.addCell(createCell("Наименование", true));
        table.addCell(createCell("Количество", true));

        // Данные таблицы
        for (int i = 1; i <= 10; i++) {
            table.addCell(createCell(String.valueOf(i), false));
            table.addCell(createCell("Товар " + i, false));
            table.addCell(createCell(String.valueOf(i * 10), false));
        }

        document.add(table);

        // Закрываем документ
        document.close();

        return outputStream.toByteArray();
    }

    private PdfPCell createCell(String content, boolean isHeader) {
        Font font = isHeader
                ? FontFactory.getFont(FontFactory.HELVETICA_BOLD, 12, BaseColor.WHITE)
                : FontFactory.getFont(FontFactory.HELVETICA, 12, BaseColor.BLACK);

        PdfPCell cell = new PdfPCell(new Phrase(content, font));
        cell.setBackgroundColor(isHeader ? BaseColor.GRAY : BaseColor.WHITE);
        cell.setPadding(5);
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        return cell;
    }

}
