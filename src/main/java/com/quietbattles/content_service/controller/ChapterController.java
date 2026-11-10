
package com.quietbattles.content_service.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.quietbattles.content_service.dto.ChapterRequest;
import com.quietbattles.content_service.dto.ChapterResponse;
import com.quietbattles.content_service.service.ChapterService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/content")
public class ChapterController {

    private final ChapterService chapterService;

    public ChapterController(ChapterService chapterService) {
        this.chapterService = chapterService;
    }

    // Create Chapter
    @PostMapping("/series/{seriesId}/chapters")
    public ResponseEntity<ChapterResponse> createChapter(
            @PathVariable Long seriesId,
            @Valid @RequestBody ChapterRequest request) {

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(chapterService.createChapter(seriesId, request));
    }

    // Get All Chapters of a Series
    @GetMapping("/series/{seriesId}/chapters")
    public ResponseEntity<List<ChapterResponse>> getChapters(
            @PathVariable Long seriesId) {

        return ResponseEntity.ok(
                chapterService.getChaptersBySeries(seriesId));
    }

    // Get Chapter By ID
    @GetMapping("/chapters/{chapterId}")
    public ResponseEntity<ChapterResponse> getChapter(
            @PathVariable Long chapterId) {

        return ResponseEntity.ok(
                chapterService.getChapterById(chapterId));
    }

    // Update Chapter
    @PutMapping("/chapters/{chapterId}")
    public ResponseEntity<ChapterResponse> updateChapter(
            @PathVariable Long chapterId,
            @Valid @RequestBody ChapterRequest request) {

        return ResponseEntity.ok(
                chapterService.updateChapter(chapterId, request));
    }

    // Delete Chapter
    @DeleteMapping("/chapters/{chapterId}")
    public ResponseEntity<Void> deleteChapter(
            @PathVariable Long chapterId) {

        chapterService.deleteChapter(chapterId);

        return ResponseEntity.noContent().build();
    }
}
