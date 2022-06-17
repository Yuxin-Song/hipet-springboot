package com.hipet.hipetspringboot.controller;

import com.hipet.hipetspringboot.entity.User;
import com.hipet.hipetspringboot.jsonify.RequestChangePassword;
import com.hipet.hipetspringboot.jsonify.ResponseStatusCode;
import com.hipet.hipetspringboot.jsonify.ResultJson;
import com.hipet.hipetspringboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

// REMIND: change it when you need it.
@CrossOrigin
        //(origins = "http://localhost:8080", maxAge = 3600)
@RestController
@RequestMapping("/user")
public class UserHandler {
    @Autowired
    private UserRepository userRepository;
    String name, phone, pwd;
    Integer id;

    @GetMapping("/login")
    public ResultJson login(User user) {
        phone = user.getPhone();
        pwd = user.getPwd();
        User user1 = userRepository.findByPhone(phone);
        if (user1 == null || !user1.getPwd().equals(pwd)) {
            return ResultJson.returnResult(ResponseStatusCode.UNAUTHORIZED.getStatusCode(), ResponseStatusCode.UNAUTHORIZED.getMsg(), null);
        } else
            return ResultJson.returnResult(ResponseStatusCode.SUCCESS.getStatusCode(), ResponseStatusCode.SUCCESS.getMsg(), user1);
    }

    @PostMapping("/register")
    public ResultJson register(@RequestBody(required = false) User user) {
        name = user.getUsername();
        pwd = user.getPwd();
        phone = user.getPhone();
        if (userRepository.findByPhone(phone) == null) {
            User user1 = new User();
            user1.setUsername(name);
            user1.setPwd(pwd);
            user1.setPhone(phone);
            userRepository.save(user1);
            return ResultJson.returnResult(ResponseStatusCode.CREATED.getStatusCode(), ResponseStatusCode.CREATED.getMsg(), user1);
        }
        return ResultJson.returnResult(ResponseStatusCode.NOT_FOUND.getStatusCode(), ResponseStatusCode.NOT_FOUND.getMsg(), null);
    }

    @PostMapping("/delete")
    public ResultJson delete(@RequestBody(required = false) User user) {
        if (userRepository.existsByPhone(user.getPhone())) {
            userRepository.delete(user);
            return ResultJson.returnResult(ResponseStatusCode.SUCCESS.getStatusCode(), ResponseStatusCode.SUCCESS.getMsg(), user);
        }
        return ResultJson.returnResult(ResponseStatusCode.NOT_FOUND.getStatusCode(), ResponseStatusCode.NOT_FOUND.getMsg(), null);
    }

    /**
     * vue: Post
     */
    @PutMapping("/update")
    public ResultJson update(@RequestBody(required = false) User user) {
        id = user.getUserid();
        name = user.getUsername();
        pwd = user.getPwd();
        phone = user.getPhone();
        if (userRepository.existsById(id)) {
            Optional<User> user1 = userRepository.findById(id);
            if (user1.isPresent()) {
                User user2 = user1.get();
                if (user2 != null) {
                    if (pwd.equals(user2.getPwd())) {
                        user2.setUsername(name);
                        user2.setPhone(phone);
                        user2.setPwd(pwd);
                        userRepository.save(user2);
                        return ResultJson.returnResult(ResponseStatusCode.SUCCESS.getStatusCode(), ResponseStatusCode.SUCCESS.getMsg(), user1);
                    }
                    return ResultJson.returnResult(ResponseStatusCode.UNAUTHORIZED.getStatusCode(), ResponseStatusCode.UNAUTHORIZED.getMsg(), null);
                }
            }
        }
        return ResultJson.returnResult(ResponseStatusCode.NOT_FOUND.getStatusCode(), ResponseStatusCode.NOT_FOUND.getMsg(), null);
    }

    @PutMapping("/updatePwd")
    public ResultJson updatePwd(@RequestBody(required = false) RequestChangePassword requestChangePassword) {

        User user = new User();
        user.setUserid(requestChangePassword.getUserid());
        user.setPwd(requestChangePassword.getOldPassword());
        String newPwd = requestChangePassword.getNewPassword();

        if (userRepository.existsById(requestChangePassword.getUserid())) {
            Optional<User> user1 = userRepository.findById(requestChangePassword.getUserid());
            if (user1.isPresent()) {
                User user2 = user1.get();
                if (user2 != null) {
                    if (requestChangePassword.getOldPassword().equals(user2.getPwd())) {
                        user2.setPwd(newPwd);
                        userRepository.save(user2);
                        return ResultJson.returnResult(ResponseStatusCode.SUCCESS.getStatusCode(), ResponseStatusCode.SUCCESS.getMsg(), user2);
                    }
                }
            }
        }
        return ResultJson.returnResult(ResponseStatusCode.NOT_FOUND.getStatusCode(), ResponseStatusCode.NOT_FOUND.getMsg(), null);
    }

    @GetMapping("/findAll")
    public List<User> findAll() {
        return userRepository.findAll();
    }

}
