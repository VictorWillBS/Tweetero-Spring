package com.tweteroo.api.controller;

import com.tweteroo.api.DTO.UserDto;
import com.tweteroo.api.Model.UserModel;
import com.tweteroo.api.service.UserService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService service;
    @GetMapping()
    public List<UserModel> findAll(){
        return service.findAll();
    }

    @GetMapping("/{username}")
    public List<UserModel> findUser(@PathVariable String username){
        return service.findUser(username);
    }
    @PostMapping("/sign-up")
    public String create(@RequestBody UserDto body){
        service.save(body);
        return "OK";
    }
}
