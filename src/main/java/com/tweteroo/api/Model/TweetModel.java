package com.tweteroo.api.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.tweteroo.api.DTO.TweetDto;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Table(name = "tweets")

public class TweetModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "userModel_id")
    @JsonManagedReference

    private UserModel userModel;
    private String tweet;
    public TweetModel(TweetDto data){
        this.tweet = data.tweet();
    }
}
