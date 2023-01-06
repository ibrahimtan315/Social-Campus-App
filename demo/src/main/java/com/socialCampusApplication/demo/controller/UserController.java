package com.socialCampusApplication.demo.controller;

import com.socialCampusApplication.demo.client.dto.request.CreateUserRequest;
import com.socialCampusApplication.demo.client.dto.request.UpdateUserRequest;
import com.socialCampusApplication.demo.client.dto.response.UserDto;
import com.socialCampusApplication.demo.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // user creating                      // validation gelen istegin servise gitmeden once kontrolunu saglar.
    @PostMapping
    public ResponseEntity<UserDto> createUser(@Valid @RequestBody CreateUserRequest userRequest){
        return ResponseEntity.ok(userService.createUser(userRequest));
    }

    // user deleting
    @DeleteMapping("/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
    }

    // user updating
    @PutMapping("/{id}")
    public ResponseEntity<UserDto> updateUser(@PathVariable Long id,
                                              @RequestBody UpdateUserRequest userRequest){
        return ResponseEntity.ok(userService.updateUser(id, userRequest));
    }

    // display user
    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable Long id){
        return ResponseEntity.ok(userService.getUserDtoById(id));
    }

}

// disariya acilan katman