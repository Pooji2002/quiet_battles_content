
package com.quietbattles.content_service.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

import com.quietbattles.content_service.dto.SeriesRequest;
import com.quietbattles.content_service.entity.Series;
import com.quietbattles.content_service.service.SeriesService;

@RestController
@RequestMapping("/api/content/series")
public class SeriesController {

    private final SeriesService seriesService;

    public SeriesController(SeriesService seriesService) {
        this.seriesService = seriesService;
    }

    // Create Series
    @PostMapping
    public ResponseEntity<Series> createSeries(
            @Valid @RequestBody SeriesRequest request) {

        return new ResponseEntity<>(
                seriesService.createSeries(request),
                HttpStatus.CREATED);
    }

    // Get All Series
    @GetMapping
    public ResponseEntity<List<Series>> getAllSeries() {

        return ResponseEntity.ok(
                seriesService.getAllSeries());
    }

    // Get Series By ID
    @GetMapping("/{id}")
    public ResponseEntity<Series> getSeriesById(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                seriesService.getSeriesById(id));
    }

    // Update Series
    @PutMapping("/{id}")
    public ResponseEntity<Series> updateSeries(
            @PathVariable Long id,
            @Valid @RequestBody SeriesRequest request) {

        return ResponseEntity.ok(
                seriesService.updateSeries(id, request));
    }

    // Delete Series
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSeries(
            @PathVariable Long id) {

        seriesService.deleteSeries(id);

        return ResponseEntity.noContent().build();
    }
}
