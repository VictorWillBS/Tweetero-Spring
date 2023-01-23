package com.tweteroo.api.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.tweteroo.api.DTO.UserDto;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@NoArgsConstructor
@Data
@Entity
@Table(name = "users")
public class UserModel {

    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Id
    @Column(length = 50, nullable = false, unique = true)
    private String username;
    @Column(nullable = false)
    private String photo;
    @OneToMany(mappedBy = "userModel", fetch = FetchType.LAZY )
    @JsonBackReference
    private List<TweetModel> tweets;
    public UserModel(UserDto data){
        this.username = data.name();
        this.photo = data.photo();
    }

}
