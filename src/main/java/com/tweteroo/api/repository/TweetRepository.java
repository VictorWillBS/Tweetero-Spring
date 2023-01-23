package com.tweteroo.api.repository;

import com.tweteroo.api.Model.TweetModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TweetRepository extends JpaRepository<TweetModel,Long> {

    @Query(
            value="SELECT t.tweet, t.username, u.avatar FROM tweets t, users u WHERE t.username = u.username",
            nativeQuery = true
    )
    List<TweetModel> findTweets();
}
