package com.estsoft.weeklyquiz.dto;

import com.estsoft.weeklyquiz.domain.Article;
import com.estsoft.weeklyquiz.domain.Comment;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class CommentResponseDto {
    private Long commentId;
    private Long articleId;
    private String body;
    private LocalDateTime createdAt;
    private ArticleDTO article;

    public CommentResponseDto(Comment comment) {
        this.commentId = comment.getCommentId();
        this.articleId = comment.getArticle().getArticleId();
        this.body = comment.getBody();
        this.createdAt = comment.getCreatedAt();
        this.article = new ArticleDTO(comment.getArticle());
    }
}

