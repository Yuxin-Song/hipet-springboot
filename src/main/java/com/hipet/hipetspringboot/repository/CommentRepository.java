package com.hipet.hipetspringboot.repository;

import com.hipet.hipetspringboot.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Integer> {
    List<Comment> findAllByToidOrderByUpdatetimeDesc(Integer toid);

    List<Comment> findAllByCommenteridOrderByUpdatetimeDesc(Integer commenterid);
}
