package com.scaler.weddingplanner.controllers;

import com.scaler.weddingplanner.services.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/reports")
public class ReportController {
    private final ReportService reportService;

    @Autowired
    public ReportController(ReportService reportService) {
        this.reportService = reportService;
    }

    @GetMapping("/monthly")
    public Map<String, Object> getMonthlyReport() {
        return reportService.generateMonthlyReport();
    }
}

