package com.twitter_backend.twitter_backend.Service;

import com.twitter_backend.twitter_backend.DAO.UserDao;
import com.twitter_backend.twitter_backend.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service("UserService")
public class UserService {

    @Autowired
    UserDao userDao;

    @Transactional
    public User fetchUserByUserId(int userId) {
        Optional<User> userResponse = userDao.findById(userId);
        if(userResponse.isEmpty()){
            return null;
        }
        else{
            return userResponse.get();
        }
    }

    public User createUser(User user) {
        try{
            User createdUser = userDao.save(user);
            return createdUser;
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }

    }
}
