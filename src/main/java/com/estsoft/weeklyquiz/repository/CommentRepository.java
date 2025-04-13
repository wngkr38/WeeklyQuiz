package com.estsoft.weeklyquiz.repository;

import com.estsoft.weeklyquiz.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {

}
