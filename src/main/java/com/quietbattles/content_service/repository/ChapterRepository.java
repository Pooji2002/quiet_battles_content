
package com.quietbattles.content_service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.quietbattles.content_service.entity.Chapter;

public interface ChapterRepository
        extends JpaRepository<Chapter, Long> {

    List<Chapter> findBySeries_IdOrderByChapterNumberAsc(Long seriesId);

    boolean existsBySeries_IdAndChapterNumber(
            Long seriesId, Integer chapterNumber);

    boolean existsBySeries_IdAndChapterNumberAndIdNot(
            Long seriesId, Integer chapterNumber, Long id);
}
