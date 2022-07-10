package com.ezms.project.controllers;

import com.ezms.project.dto.UserDTO;
import com.ezms.project.exceptions.NotFoundException;
import com.ezms.project.models.User;
import com.ezms.project.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.hibernate.PropertyValueException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;


@RestController
@RequestMapping
@AllArgsConstructor
public class UserController {

    private final UserRepository repository;

    private final PasswordEncoder encoder;

    @PostMapping("/register")
    public ResponseEntity<Object> register(@RequestBody User userBody) {
        User newUser;

        try {
            userBody.setPassword(encoder.encode(userBody.getPassword()));
            newUser = repository.save(userBody);

            return new ResponseEntity<>(new UserDTO(newUser.getUserId(), newUser.getUsername(), newUser.getEmail())
                    , HttpStatus.CREATED);
        } catch (PropertyValueException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/users")
    public ResponseEntity<Object> getAllUsers() {
        ArrayList<UserDTO> userResponseData = new ArrayList<>();

        try {
            ArrayList<User> userList = repository.findAll();

            if (userList.isEmpty()) {
                throw new NotFoundException();
            }

            for (User user : userList) {
                userResponseData.add(new UserDTO(user.getUserId(), user.getUsername(), user.getEmail()));
            }

            return new ResponseEntity<>(userResponseData, HttpStatus.OK);
        } catch (NotFoundException e) {
            throw new NotFoundException("[MESSAGE]");
        }
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<Object> getUserById(@PathVariable("id") UUID id) {
        try {
            Optional<User> user = repository.findById(id);

            if (user.isEmpty())
                throw new NotFoundException();

            return new ResponseEntity<>(new UserDTO(user.get().getUserId(), user.get().getUsername(),
                    user.get().getEmail()), HttpStatus.OK);
        } catch (NotFoundException e) {
            throw new NotFoundException("[MESSAGE]");
        }
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<Object> updateCompleteUser(@PathVariable("id") UUID id, @RequestBody User userBody) {
        try {
            userBody.setUserId(id);
            userBody.setPassword(encoder.encode(userBody.getPassword()));

            User newUserData = repository.save(userBody);

            return new ResponseEntity<>(new UserDTO(newUserData.getUserId(), newUserData.getUsername()
                    , newUserData.getEmail()), HttpStatus.OK);
        } catch (PropertyValueException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<Object> deleteUser(@PathVariable("id") UUID id) {
        try {
            repository.deleteById(id);

            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            System.err.println(e.getMessage());

            return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
        }
    }
}
