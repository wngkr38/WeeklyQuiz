package com.estsoft.weeklyquiz.repository;

import com.estsoft.weeklyquiz.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, Long> {

}
