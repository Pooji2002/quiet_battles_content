
package com.quietbattles.content_service.dto;

import java.time.LocalDateTime;

public class ChapterResponse {

    private Long id;
    private Long seriesId;
    private Long productId;
    private Integer chapterNumber;
    private String title;
    private String content;
    private String imageUrl;
    private String status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public ChapterResponse() {
    }

    public ChapterResponse(
            Long id,
            Long seriesId,
            Long productId,
            Integer chapterNumber,
            String title,
            String content,
            String imageUrl,
            String status,
            LocalDateTime createdAt,
            LocalDateTime updatedAt) {

        this.id = id;
        this.seriesId = seriesId;
        this.productId = productId;
        this.chapterNumber = chapterNumber;
        this.title = title;
        this.content = content;
        this.imageUrl = imageUrl;
        this.status = status;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
    
    public Long getId() {
        return id;
    }

    public Long getSeriesId() {
        return seriesId;
    }
    
    public Long getProductId() {
        return productId;
    }

    public Integer getChapterNumber() {
        return chapterNumber;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }
    
    public String getImageUrl() {
        return imageUrl;
    }

    public String getStatus() {
        return status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }
}
