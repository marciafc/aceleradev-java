package com.challenge.mappers;

import com.challenge.dto.UserDTO;
import com.challenge.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;
import java.util.Set;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "fullName", target = "fullName"),
            @Mapping(source = "email", target = "email"),
            @Mapping(source = "nickname", target = "nickname"),
            @Mapping(source = "createdAt", target = "createdAt", dateFormat = "yyyy-MM-dd HH:mm"),
    })

    UserDTO map(User user);

    List<UserDTO> map(List<User> user);

    List<UserDTO> map(Set<User> user);
}