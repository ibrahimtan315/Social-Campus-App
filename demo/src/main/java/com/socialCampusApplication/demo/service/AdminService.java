package com.socialCampusApplication.demo.service;

import com.socialCampusApplication.demo.client.dto.request.CreateAdminRequest;
import com.socialCampusApplication.demo.client.dto.request.UpdateAdminRequest;
import com.socialCampusApplication.demo.client.dto.response.AdminDto;
import com.socialCampusApplication.demo.client.dto.response.UserDto;
import com.socialCampusApplication.demo.mapper.AdminMapper;
import com.socialCampusApplication.demo.mapper.UserMapper;
import com.socialCampusApplication.demo.model.Admin;
import com.socialCampusApplication.demo.model.User;
import com.socialCampusApplication.demo.repository.AdminRepository;
import com.socialCampusApplication.demo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Slf4j
@Service
public class AdminService {

    private final AdminRepository adminRepository;

    private final UserRepository userRepository;

    private final AdminMapper adminMapper;

    private final UserMapper userMapper;

    // create admin
    public AdminDto createAdmin(CreateAdminRequest adminRequest){
        Admin admin = adminMapper.toAdminFromCreateAdminRequest(adminRequest);

        return adminMapper.toAdminDto(adminRepository.save(admin));
    }

    // delete admin
    public void deleteAdmin(Long id){
        adminRepository.deleteById(id);
    }

    // update admin
    public AdminDto updateAdmin(Long id, UpdateAdminRequest adminRequest) {
        Optional<Admin> adminOptional = adminRepository.findById(id);

        adminOptional.ifPresent(admin -> {
            admin.setName(adminRequest.getName());
            admin.setBirthDate(adminRequest.getBirthDate());
            adminRepository.save(admin);
        });

        return adminOptional.map(adminMapper::toAdminDto)
                .orElseThrow();
    }


    /* ------------------------- User service by admin ----------------------- */


    // get all users -> only use admins
    public List<UserDto> getAllUsers(){
        List<User> userList = userRepository.findAll();     // burayi degistir admin sevice direk user repoya ulasmasi sagliksiz, user service kullanmaliyiz

        return userList.stream()
                .map(userMapper::toUserDto)
                .collect(Collectors.toList());
    }

    //delete user by admin
    public void deleteUserByAdmin(Long id){
        userRepository.deleteById(id);
    }

}
