package com.hipet.hipetspringboot.repository;

import com.hipet.hipetspringboot.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Integer> {

}
