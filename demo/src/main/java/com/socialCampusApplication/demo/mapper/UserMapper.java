package com.socialCampusApplication.demo.mapper;

import com.socialCampusApplication.demo.client.dto.request.CreateUserRequest;
import com.socialCampusApplication.demo.client.dto.response.UserDto;
import com.socialCampusApplication.demo.model.User;
import org.mapstruct.Mapper;

@Mapper(implementationName = "UserMapperImpl", componentModel = "spring")
public interface UserMapper {

    User toUser(UserDto userDto);

    UserDto toUserDto(User user);

    User toUserFromCreateUserRequest(CreateUserRequest userRequest);

}
