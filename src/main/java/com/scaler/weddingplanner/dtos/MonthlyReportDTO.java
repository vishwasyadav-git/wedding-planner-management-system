package com.scaler.weddingplanner.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;
@Getter
@Setter
public class MonthlyReportDTO {
    private int totalClients;
    private int totalEvents;
    private double totalRevenue;
    private Map<String, Integer> eventStatusCounts;

    // Constructors
    public MonthlyReportDTO() {
    }

    public MonthlyReportDTO(int totalClients, int totalEvents, double totalRevenue, Map<String, Integer> eventStatusCounts) {
        this.totalClients = totalClients;
        this.totalEvents = totalEvents;
        this.totalRevenue = totalRevenue;
        this.eventStatusCounts = eventStatusCounts;
    }

}

