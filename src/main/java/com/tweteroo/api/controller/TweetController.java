package com.tweteroo.api.controller;

import com.tweteroo.api.DTO.TweetDto;
import com.tweteroo.api.Model.TweetModel;
import com.tweteroo.api.service.TweetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tweet")
public class TweetController {
    @Autowired
    private TweetService service;
    @GetMapping()
    public List<TweetModel> findAll(){
        return service.findAll();
    }
    @PostMapping()
    public void save(@RequestBody TweetDto body){
         service.save(body);
    }
}