package com.notesapp.controller;

import com.notesapp.model.Users;
import com.notesapp.service.UsersService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UsersController {

    private final UsersService usersService;

    public UsersController(UsersService usersService) {
        this.usersService = usersService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Users>> getAllUsers() {
        try {
            return ResponseEntity.ok(usersService.findAll());
        } catch (Exception e) {
            return ResponseEntity.status(404).body(null);
        }
    }

    @GetMapping("/all/{user_id}")
    public ResponseEntity<Users> getUsersById(@PathVariable int user_id) {
        try {
            return ResponseEntity.ok(usersService.findById(user_id));
        } catch (Exception e) {
            return ResponseEntity.status(404).body(null);
        }
    }

    //???????
    @PostMapping("/")
    public ResponseEntity<Users> saveUser(@RequestBody Users users) {
        try {
            return ResponseEntity.ok(usersService.save(users));
        } catch (Exception e) {
            return ResponseEntity.status(404).body(null);
        }
    }

    //??
    @DeleteMapping("/all")
    public ResponseEntity<String> deleteAllUsers() {
        try {
            usersService.deleteAll();
            return ResponseEntity.ok("All users were deleted");
        } catch (Exception e) {
            return ResponseEntity.status(404).body("Users not found");
        }
    }

    //need to delete all notes of this user ???
    @DeleteMapping("/all/{user_id}")
    public ResponseEntity<String> deleteUserById(@PathVariable int user_id) {
        try {
            usersService.deleteById(user_id);
            return ResponseEntity.ok("User with id " + user_id + " was deleted");
        } catch (Exception e) {
            return ResponseEntity.status(404).body("User not found with id " + user_id);
        }
    }


}
