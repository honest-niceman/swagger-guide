package com.example.swaggerguide.controllers;

import com.example.swaggerguide.dtos.VisitWithPetDto;
import com.example.swaggerguide.mappers.VisitMapper;
import com.example.swaggerguide.services.StatisticsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/statistics")
public class StatisticsController {
    private final StatisticsService statisticsService;
    private final VisitMapper visitMapper;

    public StatisticsController(StatisticsService statisticsService,
                                VisitMapper visitMapper) {
        this.statisticsService = statisticsService;
        this.visitMapper = visitMapper;
    }

    @GetMapping("/getVisits/")
    public List<VisitWithPetDto> getVisits(@RequestParam("start") OffsetDateTime start,
                                           @RequestParam("end") OffsetDateTime end) {
        return statisticsService.getVisitsFromInterval(start, end)
                                .stream()
                                .map(visitMapper::toDto)
                                .collect(Collectors.toList());
    }
}
