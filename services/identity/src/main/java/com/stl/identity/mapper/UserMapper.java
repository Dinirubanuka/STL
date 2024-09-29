package com.stl.identity.mapper;


import com.stl.identity.entity.User;
import com.stl.identity.dto.response.UserResponseDTO;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public UserResponseDTO toUserResponseDTO(User user) {
        if (user == null) {
            return null;
        }
        return UserResponseDTO.builder()
                .id(user.getId())
                .firstname(user.getFirstname())
                .lastname(user.getLastname())
                .email(user.getEmail())
                .mobileNumber(user.getMobileNumber())
                .NIC(user.getNIC())
                .build();
    }
}
