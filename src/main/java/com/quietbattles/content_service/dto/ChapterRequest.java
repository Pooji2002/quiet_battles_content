
package com.quietbattles.content_service.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public class ChapterRequest {

    @NotNull(message = "Chapter number is required")
    @Positive(message = "Chapter number must be positive")
    private Integer chapterNumber;

    @NotBlank(message = "Chapter title is required")
    @Size(max = 150, message = "Title cannot exceed 150 characters")
    private String title;

    private String content;
    
    @Size(max = 1000, message = "Image URL cannot exceed 1000 characters")
    private String imageUrl;
    
    @Positive(message = "Product ID must be positive")
    private Long productId;

    @NotBlank(message = "Status is required")
    @Pattern(
        regexp = "DRAFT|PUBLISHED|ARCHIVED",
        message = "Status must be DRAFT, PUBLISHED or ARCHIVED"
    )
    private String status;

    public ChapterRequest() {
    }

    public Integer getChapterNumber() {
        return chapterNumber;
    }

    public void setChapterNumber(Integer chapterNumber) {
        this.chapterNumber = chapterNumber;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }
    
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
