package com.example.swaggerguide.services;

import com.example.swaggerguide.model.Visit;
import com.example.swaggerguide.repositories.VisitRepository;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.List;

@Service
public class StatisticsService {
    private final VisitRepository visitRepository;

    public StatisticsService(VisitRepository visitRepository) {
        this.visitRepository = visitRepository;
    }

    public List<Visit> getVisitsFromInterval(OffsetDateTime start, OffsetDateTime end) {
        return visitRepository.findByDateBetween(start, end);
    }
}