package com.estsoft.weeklyquiz.service;

import com.estsoft.weeklyquiz.domain.Article;
import com.estsoft.weeklyquiz.domain.Comment;
import com.estsoft.weeklyquiz.dto.CommentRequest;
import com.estsoft.weeklyquiz.dto.CommentResponseDto;
import com.estsoft.weeklyquiz.repository.ArticleRepository;
import com.estsoft.weeklyquiz.repository.CommentRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;
    private final ArticleRepository articleRepository; // 이미 존재한다고 가정

    public Comment saveComment(Long articleId, Comment comment) {
        Article article = articleRepository.findById(articleId)
                .orElseThrow(() -> new RuntimeException("게시글 찾을 수 없음"));

        comment.setArticle(article);

        return commentRepository.save(comment);
    }

    public Comment getComment(Long commentId) {
        return commentRepository.findById(commentId)
                .orElseThrow(() -> new EntityNotFoundException("댓글을 찾을 수 없음" + commentId));
    }

    public Comment updateComment(Long commentId, CommentRequest request) {
        Comment comment = commentRepository.findById(commentId)
                .orElseThrow(() -> new RuntimeException("댓글을 찾을 수 없음"));

        comment.setBody(request.getBody());
        return comment;
    }
    public void deleteComment(Long commentId) {
        commentRepository.deleteById(commentId);
    }

    public List<CommentResponseDto> AllComments(Long articleId) {
        Article article = articleRepository.findById(articleId)
                .orElseThrow(() -> new RuntimeException("게시글 없음"));

        return article.getComments().stream()
                .map(CommentResponseDto::new)
                .collect(Collectors.toList());
    }
}

