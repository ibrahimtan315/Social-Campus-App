package com.socialCampusApplication.demo.mapper;

import com.socialCampusApplication.demo.client.dto.request.CreateAdminRequest;
import com.socialCampusApplication.demo.client.dto.response.AdminDto;
import com.socialCampusApplication.demo.model.Admin;
import org.mapstruct.Mapper;

@Mapper(implementationName = "AdminMapperImpl", componentModel = "spring")
public interface AdminMapper {

    Admin toAdmin(AdminDto adminDto);

    AdminDto toAdminDto(Admin admin);

    Admin toAdminFromCreateAdminRequest(CreateAdminRequest createAdminRequest);

}
