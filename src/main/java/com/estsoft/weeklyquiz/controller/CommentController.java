package com.estsoft.weeklyquiz.controller;

import com.estsoft.weeklyquiz.domain.Comment;
import com.estsoft.weeklyquiz.dto.CommentRequest;
import com.estsoft.weeklyquiz.dto.CommentResponseDto;
import com.estsoft.weeklyquiz.service.CommentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CommentController {
    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping("/api/articles/{articleId}/comments")
    public ResponseEntity<CommentResponseDto> addComment(@PathVariable("articleId") Long articleId, @RequestBody Comment comment) {

        Comment saveComment = commentService.saveComment(articleId, comment);
        return ResponseEntity.status(HttpStatus.CREATED).body(new CommentResponseDto(saveComment));
    }

    @GetMapping("/api/comments/{commentId}")
    public ResponseEntity<CommentResponseDto> getComment(@PathVariable("commentId") Long commentId) {
        Comment comment = commentService.getComment(commentId);
        return ResponseEntity.ok(new CommentResponseDto(comment));
    }

    @PutMapping("/api/comments/{commentId}")
    public ResponseEntity<CommentResponseDto>  updateComment(@PathVariable("commentId") Long commentId, @RequestBody CommentRequest request) {
        Comment comment = commentService.updateComment(commentId, request);
        return ResponseEntity.ok(new CommentResponseDto(comment));
    }

    @DeleteMapping("/api/comments/{commentId}")
    public ResponseEntity<String> deleteComment(@PathVariable("commentId") Long commentId) {
        commentService.deleteComment(commentId);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/api/articles/{articleId}/comments")
    public ResponseEntity<List<CommentResponseDto>> getComments(@PathVariable("articleId") Long articleId) {
        List<CommentResponseDto> comments = commentService.AllComments(articleId);
        return ResponseEntity.ok(comments);
    }

}
