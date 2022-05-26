package com.hipet.hipetspringboot.controller;

import com.hipet.hipetspringboot.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// REMIND: change it when you need it.
@CrossOrigin
        //(origins = "http://localhost:8080", maxAge = 3600)
@RestController
@RequestMapping("/comment")
public class CommentHandler {
    @Autowired
    private CommentRepository commentRepository;

}
