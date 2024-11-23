package com.weddingplanner.services;

import com.weddingplanner.repositories.BookingRepository;
import com.weddingplanner.repositories.ClientRepository;
import com.weddingplanner.repositories.EventRepository;
import com.weddingplanner.repositories.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.HashMap;
import java.util.Map;

@Service
public class ReportService {
    private final ClientRepository clientRepository;
    private final EventRepository eventRepository;
    private final BookingRepository bookingRepository;
    private final PaymentRepository paymentRepository;

    @Autowired
    public ReportService(ClientRepository clientRepository, EventRepository eventRepository,
                         BookingRepository bookingRepository, PaymentRepository paymentRepository) {
        this.clientRepository = clientRepository;
        this.eventRepository = eventRepository;
        this.bookingRepository = bookingRepository;
        this.paymentRepository = paymentRepository;
    }

    public Map<String, Object> generateMonthlyReport() {
        LocalDate now = LocalDate.now();
        YearMonth previousMonth = YearMonth.from(now.minusMonths(1));

        Map<String, Object> report = new HashMap<>();
        report.put("totalClients", clientRepository.count());
        report.put("totalEvents", eventRepository.findByDateAfter(previousMonth.atDay(1)).size());
        report.put("totalRevenue", paymentRepository.findMonthlyRevenue(previousMonth.getMonthValue(), previousMonth.getYear()));

        return report;
    }
}

