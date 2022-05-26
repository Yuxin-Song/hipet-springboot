package com.hipet.hipetspringboot.controller;

import com.hipet.hipetspringboot.entity.Article;
import com.hipet.hipetspringboot.jsonify.ResponseStatusCode;
import com.hipet.hipetspringboot.jsonify.ResultJson;
import com.hipet.hipetspringboot.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

// REMIND: change it when you need it.
@CrossOrigin
        //(origins = "http://localhost:8080", maxAge = 3600)
@RestController
@RequestMapping("/article")
public class ArticleHandler {
    @Autowired
    private ArticleRepository articleRepository;

    @PostMapping("/post")
    public ResultJson post(@RequestBody Article article) {
        Article article1 = new Article();
        article1.setPosterid(article.getPosterid());
        article1.setTitle(article.getTitle());
        article1.setContent(article.getContent());
        articleRepository.save(article1);
        return ResultJson.returnResult(ResponseStatusCode.CREATED.getStatusCode(), ResponseStatusCode.CREATED.getMsg(), article1);
    }

    @DeleteMapping("/delete")
    public ResultJson delete(@RequestBody Article article) {
        if (articleRepository.existsById(article.getArticleid())) {
            articleRepository.deleteById(article.getArticleid());
            return ResultJson.returnResult(ResponseStatusCode.SUCCESS.getStatusCode(), ResponseStatusCode.SUCCESS.getMsg(), article);
        }
        return ResultJson.returnResult(ResponseStatusCode.NOT_FOUND.getStatusCode(), ResponseStatusCode.NOT_FOUND.getMsg(), null);
    }

    @PutMapping("/update")
    public ResultJson update(@RequestBody Article article) {
        if (articleRepository.existsById(article.getArticleid())) {
            Optional<Article> article1 = articleRepository.findById(article.getArticleid());
            if (article1.isPresent()) {
                Article article2 = article1.get();
                if (article2 != null) {
                    article2.setTitle(article.getTitle());
                    article2.setContent(article.getContent());
                    articleRepository.save(article2);
                    return ResultJson.returnResult(ResponseStatusCode.SUCCESS.getStatusCode(), ResponseStatusCode.SUCCESS.getMsg(), article2);
                }
            }
        }
        return ResultJson.returnResult(ResponseStatusCode.NOT_FOUND.getStatusCode(), ResponseStatusCode.NOT_FOUND.getMsg(), null);
    }

    /**
     * Show all article by desc on update time.
     * */
    @GetMapping("/showAll")
    public ResultJson showAll() {
        return ResultJson.returnResult(ResponseStatusCode.SUCCESS.getStatusCode(), ResponseStatusCode.SUCCESS.getMsg(), articleRepository.findAllByOrderByUpdatetimeDesc());
    }

    /**
     * show all article from a special poster.
     *
     * */
    @GetMapping("/showAllByPoster")
    public ResultJson showAllByPoster(@RequestBody Article article) {
        return ResultJson.returnResult(ResponseStatusCode.SUCCESS.getStatusCode(), ResponseStatusCode.SUCCESS.getMsg(), articleRepository.findAllByPosteridOrderByUpdatetimeDesc(article.getPosterid()));
    }

    /**
     * Show the article called.
     * */

    @GetMapping("/showOne")
    public ResultJson showOne(@RequestBody Article article) {
        return ResultJson.returnResult(ResponseStatusCode.SUCCESS.getStatusCode(), ResponseStatusCode.SUCCESS.getMsg(), articleRepository.findById(article.getArticleid()));
    }

    @GetMapping("/findAll")
    public List<Article> findAll() {
        return articleRepository.findAll();
    }

}
