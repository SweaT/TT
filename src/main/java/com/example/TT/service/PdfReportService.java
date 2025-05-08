package com.example.TT.service;

import com.itextpdf.text.DocumentException;

public interface PdfReportService {

    byte[] generateReport() throws DocumentException;
}
