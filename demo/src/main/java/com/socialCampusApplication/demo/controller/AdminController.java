package com.socialCampusApplication.demo.controller;


import com.socialCampusApplication.demo.client.dto.request.CreateAdminRequest;
import com.socialCampusApplication.demo.client.dto.request.UpdateAdminRequest;
import com.socialCampusApplication.demo.client.dto.response.AdminDto;
import com.socialCampusApplication.demo.client.dto.response.UserDto;
import com.socialCampusApplication.demo.service.AdminService;
import com.socialCampusApplication.demo.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/admins")
public class AdminController {

    private final AdminService adminService;

    public AdminController(AdminService adminService, UserService userService) {
        this.adminService = adminService;
    }


    // creating admin
    @PostMapping
    public ResponseEntity<AdminDto> createAdmin(@Valid @RequestBody CreateAdminRequest adminRequest){
        return ResponseEntity.ok(adminService.createAdmin(adminRequest));
    }

    // deleting admin
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAdmin(@PathVariable Long id){
        adminService.deleteAdmin(id);
    }

    // updating admin
    @PutMapping("/{id}")
    public ResponseEntity<AdminDto> updateAdmin(@PathVariable Long id,
                                                @RequestBody UpdateAdminRequest adminRequest){
        return ResponseEntity.ok(adminService.updateAdmin(id, adminRequest));
    }

/* ------------------------- User controller by admin ----------------------- */

    // deleting user
    @DeleteMapping("/user/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUserByAdmin(@PathVariable Long id){
            adminService.deleteUserByAdmin(id);
    }

    // get all users -> only use admins
    @GetMapping
    public ResponseEntity<List<UserDto>> getAllUsers(){
        return ResponseEntity.ok(adminService.getAllUsers());
    }

    // get user single

}
