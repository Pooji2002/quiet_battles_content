
package com.quietbattles.content_service.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import com.quietbattles.content_service.dto.ChapterRequest;
import com.quietbattles.content_service.dto.ChapterResponse;
import com.quietbattles.content_service.entity.Chapter;
import com.quietbattles.content_service.entity.Series;
import com.quietbattles.content_service.repository.ChapterRepository;
import com.quietbattles.content_service.repository.SeriesRepository;

@Service
@Transactional
public class ChapterService {

    private final ChapterRepository chapterRepository;
    private final SeriesRepository seriesRepository;

    public ChapterService(
            ChapterRepository chapterRepository,
            SeriesRepository seriesRepository) {

        this.chapterRepository = chapterRepository;
        this.seriesRepository = seriesRepository;
    }

    // Create Chapter
    public ChapterResponse createChapter(
            Long seriesId, ChapterRequest request) {

        Series series = getSeries(seriesId);

        if (chapterRepository.existsBySeries_IdAndChapterNumber(
                seriesId, request.getChapterNumber())) {

            throw new ResponseStatusException(
                    HttpStatus.CONFLICT,
                    "Chapter number already exists in this series");
        }

        Chapter chapter = new Chapter();

        chapter.setSeries(series);
        chapter.setChapterNumber(request.getChapterNumber());
        chapter.setTitle(request.getTitle());
        chapter.setContent(request.getContent());
        chapter.setImageUrl(request.getImageUrl());
        chapter.setProductId(request.getProductId());
        chapter.setStatus(request.getStatus());

        return convertToResponse(chapterRepository.save(chapter));
    }

    // Get All Chapters of a Series
    @Transactional(readOnly = true)
    public List<ChapterResponse> getChaptersBySeries(Long seriesId) {

        getSeries(seriesId);

        return chapterRepository
                .findBySeries_IdOrderByChapterNumberAsc(seriesId)
                .stream()
                .map(this::convertToResponse)
                .toList();
    }

    // Get Chapter By ID
    @Transactional(readOnly = true)
    public ChapterResponse getChapterById(Long chapterId) {

        Chapter chapter = getChapter(chapterId);

        return convertToResponse(chapter);
    }

    // Update Chapter
    public ChapterResponse updateChapter(
            Long chapterId, ChapterRequest request) {

        Chapter chapter = getChapter(chapterId);

        Long seriesId = chapter.getSeries().getId();

        if (chapterRepository
                .existsBySeries_IdAndChapterNumberAndIdNot(
                        seriesId,
                        request.getChapterNumber(),
                        chapterId)) {

            throw new ResponseStatusException(
                    HttpStatus.CONFLICT,
                    "Chapter number already exists in this series");
        }

        chapter.setChapterNumber(request.getChapterNumber());
        chapter.setTitle(request.getTitle());
        chapter.setContent(request.getContent());
        chapter.setImageUrl(request.getImageUrl());
        chapter.setProductId(request.getProductId());
        chapter.setStatus(request.getStatus());

        return convertToResponse(chapterRepository.save(chapter));
    }

    // Delete Chapter
    public void deleteChapter(Long chapterId) {

        Chapter chapter = getChapter(chapterId);

        chapterRepository.delete(chapter);
    }

    // Helper Methods
    private Series getSeries(Long seriesId) {

        return seriesRepository.findById(seriesId)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Series not found with ID: " + seriesId));
    }

    private Chapter getChapter(Long chapterId) {

        return chapterRepository.findById(chapterId)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Chapter not found with ID: " + chapterId));
    }

    private ChapterResponse convertToResponse(Chapter chapter) {
        return new ChapterResponse(
                chapter.getId(),
                chapter.getSeries().getId(),
                chapter.getProductId(),
                chapter.getChapterNumber(),
                chapter.getTitle(),
                chapter.getContent(),
                chapter.getImageUrl(),
                chapter.getStatus(),
                chapter.getCreatedAt(),
                chapter.getUpdatedAt()
        );
    }
}
