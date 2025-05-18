package com.example.TT.service.impl;

import com.example.TT.dto.response.statistics.PlayerStatisticsResponse;
import com.example.TT.service.PdfReportService;
import com.example.TT.service.StatisticsService;
import com.example.TT.service.UserService;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PdfReportServiceImpl implements PdfReportService {

    private final StatisticsService statisticsService;
    private final UserService userService;

    @Override
    public byte[] generateReportByEveryPlayerInTeam(UUID teamId) throws DocumentException {
        var players = userService.getAllPlayersInTeam(teamId, Pageable.unpaged());
        if (players.isEmpty()) {
            return null;
        }

        List<PlayerStatisticsResponse> stat = players.stream().map(each -> statisticsService.getPlayerStatistics(each.id()))
                .toList();
        // Создаем документ
        Document document = new Document();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        // Получаем writer для документа
        PdfWriter pdfWriter = PdfWriter.getInstance(document, outputStream);

        // Открываем документ
        document.open();

        // Добавляем содержимое
        Font titleFont = FontFactory.getFont(FontFactory.TIMES_BOLD, 18, BaseColor.BLACK);
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
        table.addCell(createCell("Имя Игрока", true));
        table.addCell(createCell("Сыгранные матчи", true));
        table.addCell(createCell("Выигранные матчи", true));

        stat.forEach(each -> {
            table.addCell(createCell(each.playerDTO().name(), false));
            table.addCell(createCell(String.valueOf(each.playedMathces().size()), false));
            table.addCell(createCell(String.valueOf(each.matchesWon()), false));
        });

        document.add(table);

        // Закрываем документ
        document.close();

        return outputStream.toByteArray();
    }

    private PdfPCell createCell(String content, boolean isHeader) {
        Font font = isHeader
                ? FontFactory.getFont(FontFactory.TIMES_BOLD, 12, BaseColor.WHITE)
                : FontFactory.getFont(FontFactory.TIMES, 12, BaseColor.BLACK);

        PdfPCell cell = new PdfPCell(new Phrase(content, font));
        cell.setBackgroundColor(isHeader ? BaseColor.GRAY : BaseColor.WHITE);
        cell.setPadding(5);
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        return cell;
    }

}
