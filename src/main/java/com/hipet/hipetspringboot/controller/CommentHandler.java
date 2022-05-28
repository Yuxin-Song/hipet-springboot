package com.hipet.hipetspringboot.controller;

import com.hipet.hipetspringboot.entity.Comment;
import com.hipet.hipetspringboot.jsonify.ResponseStatusCode;
import com.hipet.hipetspringboot.jsonify.ResultJson;
import com.hipet.hipetspringboot.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

// REMIND: change it when you need it.
@CrossOrigin
        //(origins = "http://localhost:8080", maxAge = 3600)
@RestController
@RequestMapping("/comment")
public class CommentHandler {
    @Autowired
    private CommentRepository commentRepository;

    @PostMapping("/add")
    public ResultJson add(@RequestBody Comment comment) {
        Comment comment1 = new Comment();
        comment1.setCommenterid(comment.getCommenterid());
        comment1.setToid(comment.getToid());
        comment1.setContent(comment.getContent());

        commentRepository.save(comment1);

        return ResultJson.returnResult(ResponseStatusCode.CREATED.getStatusCode(), ResponseStatusCode.CREATED.getMsg(), comment1);
    }

    @PostMapping("/delete")
    public ResultJson delete(@RequestBody Comment comment) {
        if (commentRepository.existsById(comment.getCommentid())) {
            commentRepository.deleteById(comment.getCommentid());

            return ResultJson.returnResult(ResponseStatusCode.SUCCESS.getStatusCode(), ResponseStatusCode.SUCCESS.getMsg(), comment);
        }
        return ResultJson.returnResult(ResponseStatusCode.NOT_FOUND.getStatusCode(), ResponseStatusCode.NOT_FOUND.getMsg(), null);
    }

    @PutMapping("/update")
    public ResultJson update(@RequestBody Comment comment) {
        if (commentRepository.existsById(comment.getCommentid())) {
            Optional<Comment> comment1 = commentRepository.findById(comment.getCommentid());
            if(comment1.isPresent()) {
                Comment comment2 = comment1.get();
                if (comment2 != null) {
                    comment2.setContent(comment.getContent());

                    commentRepository.save(comment2);

                    return ResultJson.returnResult(ResponseStatusCode.SUCCESS.getStatusCode(), ResponseStatusCode.SUCCESS.getMsg(), comment2);
                }
            }
        }
        return ResultJson.returnResult(ResponseStatusCode.NOT_FOUND.getStatusCode(), ResponseStatusCode.NOT_FOUND.getMsg(), null);
    }

    /**
     * Show all comments under an article.
     * */

    @PostMapping("/showAll")
    public ResultJson showAll(@RequestBody Comment comment) {
        return ResultJson.returnResult(ResponseStatusCode.SUCCESS.getStatusCode(), ResponseStatusCode.SUCCESS.getMsg(), commentRepository.findAllByToidOrderByUpdatetimeDesc(comment.getToid()));
    }

    /**
     * Show all of someone's comments.
     * */

    @PostMapping("/showAllByCommenter")
    public ResultJson showAllByCommenter(@RequestBody Comment comment) {
        return ResultJson.returnResult(ResponseStatusCode.SUCCESS.getStatusCode(), ResponseStatusCode.SUCCESS.getMsg(), commentRepository.findAllByCommenteridOrderByUpdatetimeDesc(comment.getCommenterid()));
    }

    @GetMapping("/findAll")
    public List<Comment> findAll() {
        return commentRepository.findAll();
    }
}
