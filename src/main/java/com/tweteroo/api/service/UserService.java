package com.tweteroo.api.service;

import com.tweteroo.api.DTO.UserDto;
import com.tweteroo.api.Model.UserModel;
import com.tweteroo.api.repository.TweetRepository;
import com.tweteroo.api.repository.UserRepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;
    @Autowired
    private TweetRepository tweetRepository;
    public List<UserModel> findAll(){
        return repository.findAll();
    }
    public List<UserModel> findUser(String username){
        return  repository.findByUsername(username);
    }
    public String save(UserDto body){
        repository.save(new UserModel(body));
        return "OK";
    }
}
