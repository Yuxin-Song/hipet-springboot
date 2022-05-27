package com.hipet.hipetspringboot.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
//(origins = "http://localhost:8080", maxAge = 3600)
@RestController
@RequestMapping("/image")
public class ImageHandler {
    /**
     * It's a bit of difficult to figure out how to transfer files(BLOB) between vue and springboot.
     * And because of the time limits.
     * So we decide not to write this part of th project in the end.
     * */
}
