package com.estsoft.weeklyquiz.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ArticlePostContent {
    private Long userId;
    private Long id;
    private String title;
    private String body;

}
