package com.hipet.hipetspringboot.repository;

import com.hipet.hipetspringboot.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ArticleRepository extends JpaRepository<Article, Integer> {
    List<Article> findAllByPosteridOrderByUpdatetimeDesc(Integer posterid);
    List<Article> findAllByOrderByUpdatetimeDesc();
}
