package com.example.TT.service;

import com.itextpdf.text.DocumentException;

import java.util.UUID;

public interface PdfReportService {

    byte[] generateReportByEveryPlayerInTeam(UUID id) throws DocumentException;
}
