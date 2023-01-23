package com.tweteroo.api.repository;

import com.tweteroo.api.Model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<UserModel,String> {
    List<UserModel> findByUsername (String username);
}
