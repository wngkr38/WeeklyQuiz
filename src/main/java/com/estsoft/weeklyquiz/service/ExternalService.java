package com.estsoft.weeklyquiz.service;

import com.estsoft.weeklyquiz.domain.Article;
import com.estsoft.weeklyquiz.domain.Comment;
import com.estsoft.weeklyquiz.dto.ArticlePostContent;
import com.estsoft.weeklyquiz.dto.CommentPostContent;
import com.estsoft.weeklyquiz.repository.ArticleRepository;
import com.estsoft.weeklyquiz.repository.CommentRepository;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
public class ExternalService {
    private final ArticleRepository articleRepository;
    private final CommentRepository commentRepository;

    public ExternalService(ArticleRepository articleRepository, CommentRepository commentRepository) {
        this.articleRepository = articleRepository;
        this.commentRepository = commentRepository;
    }

    public void getArticles() {
        String url = "https://jsonplaceholder.typicode.com/posts";

        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<List<ArticlePostContent>> response =
                restTemplate.exchange(url, HttpMethod.GET, null, new ParameterizedTypeReference<>() {
                });

        if (response.getBody() != null) {
            List<ArticlePostContent> articlePostContents = response.getBody();

            for (ArticlePostContent articlePostContent : articlePostContents) {
                Article article = new Article();
                article.setTitle(articlePostContent.getTitle());
                article.setContent(articlePostContent.getBody());
                articleRepository.save(article);

            }
        }

    }

    public void getComments() {
        String url = "https://jsonplaceholder.typicode.com/comments";

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<CommentPostContent>> response =
                restTemplate.exchange(url, HttpMethod.GET, null, new ParameterizedTypeReference<>() {
                });

        if (response.getBody() != null) {
            List<CommentPostContent> commentPostContents = response.getBody();

            for (CommentPostContent commentData : commentPostContents) {
                articleRepository.findById(commentData.getPostId()).ifPresent(article -> {
                    Comment comment = new Comment();
                    comment.setBody(commentData.getBody());
                    comment.setArticle(article);
                    commentRepository.save(comment);
                });
            }
        }
    }
}
