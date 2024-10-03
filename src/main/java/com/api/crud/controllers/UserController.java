package com.api.crud.controllers;


import com.api.crud.models.UserModel;
import com.api.crud.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ArrayList<UserModel> getUsers() {
        return this.userService.getAllUsers();
    }

    @PostMapping
    public UserModel saveUser(@RequestBody UserModel user) {
        return this.userService.saveUser(user);
    }

    @GetMapping(path = "/{id}")
    public Optional<UserModel> getUserById(@PathVariable long id) {
        return this.userService.getUserById(id);
    }

    @PutMapping(path = "/{id}")
    public UserModel updateUserById(@RequestBody UserModel request, @PathVariable long id) {
        return this.userService.updateById(request, id);

    }
    @DeleteMapping(path ="/{id}")
    public String deleteById(@PathVariable long id) {
        boolean ok = this.userService.deteleUser(id);

        if(ok){
            return "User with id" + id + "deleted";
        }else{
            return "Error, we have a problem and cant delete this user";
        }
    }

}
