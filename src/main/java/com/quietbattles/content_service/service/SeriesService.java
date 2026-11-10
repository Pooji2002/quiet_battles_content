
package com.quietbattles.content_service.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import com.quietbattles.content_service.dto.SeriesRequest;
import com.quietbattles.content_service.entity.Series;
import com.quietbattles.content_service.repository.SeriesRepository;

@Service
@Transactional
public class SeriesService {

    private final SeriesRepository seriesRepository;

    public SeriesService(SeriesRepository seriesRepository) {
        this.seriesRepository = seriesRepository;
    }

    public Series createSeries(SeriesRequest request) {

        Series series = new Series();

        series.setTitle(request.getTitle());
        series.setDescription(request.getDescription());
        series.setCoverImageUrl(request.getCoverImageUrl());
        series.setStatus(request.getStatus());

        return seriesRepository.save(series);
    }

    @Transactional(readOnly = true)
    public List<Series> getAllSeries() {
        return seriesRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Series getSeriesById(Long id) {

        return seriesRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Series not found with ID: " + id));
    }

    public Series updateSeries(Long id, SeriesRequest request) {

        Series existingSeries = getSeriesById(id);

        existingSeries.setTitle(request.getTitle());
        existingSeries.setDescription(request.getDescription());
        existingSeries.setCoverImageUrl(request.getCoverImageUrl());
        existingSeries.setStatus(request.getStatus());

        return seriesRepository.save(existingSeries);
    }

    public void deleteSeries(Long id) {

        Series existingSeries = getSeriesById(id);

        seriesRepository.delete(existingSeries);
    }
}
