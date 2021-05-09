package com.twitter_backend.twitter_backend.DAO;

import com.twitter_backend.twitter_backend.Model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserDao extends CrudRepository<User, Integer> {
}
