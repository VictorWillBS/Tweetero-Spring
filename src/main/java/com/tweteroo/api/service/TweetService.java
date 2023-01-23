package com.tweteroo.api.service;

import com.tweteroo.api.DTO.TweetDto;
import com.tweteroo.api.Model.TweetModel;
import com.tweteroo.api.Model.UserModel;
import com.tweteroo.api.repository.TweetRepository;
import com.tweteroo.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import java.util.List;
@Service
public class TweetService {
    @Autowired
    private TweetRepository repository;
    @Autowired
    private UserRepository userRepository;
    @PostMapping
    public void save( TweetDto body){
        List< UserModel> user = userRepository.findByUsername(body.username());
        TweetModel tweet= new TweetModel();
        tweet.setTweet(body.tweet());
        tweet.setUserModel(user.get(0));
        repository.save(tweet);

    }
    @GetMapping
    public List<TweetModel> findAll(){
        return repository.findAll();
    }
}
