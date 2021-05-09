package com.twitter_backend.twitter_backend.Controller;
import com.twitter_backend.twitter_backend.Model.User;
import com.twitter_backend.twitter_backend.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/fetchUserByUserId/{userId}")
    public User fetchUserByUserId(@PathVariable int userId) {
        return userService.fetchUserByUserId(userId);
    }

    @PostMapping("/createUser")
    public User createUser(@RequestBody User newUser) {
        User createdUser = userService.createUser(newUser);
        if(createdUser != null){
         return createdUser;
        }
        return null;
    }
}
