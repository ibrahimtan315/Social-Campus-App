package com.socialCampusApplication.demo.service;

import com.socialCampusApplication.demo.client.dto.request.CreateUserRequest;
import com.socialCampusApplication.demo.client.dto.request.UpdateUserRequest;
import com.socialCampusApplication.demo.client.dto.response.ConversationDto;
import com.socialCampusApplication.demo.client.dto.response.UserDto;
import com.socialCampusApplication.demo.exception.UserNotFoundException;
import com.socialCampusApplication.demo.mapper.UserMapper;
import com.socialCampusApplication.demo.model.User;
import com.socialCampusApplication.demo.model.enums.Department;
import com.socialCampusApplication.demo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@RequiredArgsConstructor
@Slf4j
@Service
public class UserService {

    private final UserRepository userRepository;

    private final UserMapper userMapper;

    private final ConversationService conversationService;

    // create user
    public UserDto createUser(CreateUserRequest userRequest){

        User user = userMapper.toUserFromCreateUserRequest(userRequest);

        return userMapper.toUserDto(userRepository.save(user));
    }

    // delete user
    public void deleteUser(Long id){
        userRepository.deleteById(id);
    }

    // update user
    public UserDto updateUser(Long id, UpdateUserRequest userRequest){
        Optional<User> userOptional = userRepository.findById(id);

        userOptional.ifPresent(user -> {
            user.setName(userRequest.getName());
            user.setBirthDate(userRequest.getBirthDate());
//            user.setDepartment(Department.valueOf(userRequest.getDepartment().name()));
            userRepository.save(user);
        });

        return userOptional.map(userMapper::toUserDto)
                .orElseThrow();
    }

    // get user by id
    @Transactional
    public UserDto getUserDtoById(long id){
        Optional<User> userOptional = userRepository.findById(id);

        return userOptional.map(userMapper::toUserDto)
                .orElseThrow(()-> new UserNotFoundException("User couldn't be found by following id: " + id));
    }


//    public void joinConversation(Long userId, ConversationDto conversationDto){
//        User user = userRepository.findById(userId).get();
//        ConversationDto conversation = conversationService.getConversationDtoById(conversationDto.getId());
//
//        user.setConversation(conversation);
//        userRepository.save(user);
//    }


}

// tum islemlerin yapildigi yer.