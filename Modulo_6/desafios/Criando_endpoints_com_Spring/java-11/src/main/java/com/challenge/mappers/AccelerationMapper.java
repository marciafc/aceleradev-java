package com.challenge.mappers;

import com.challenge.dto.AccelerationDTO;
import com.challenge.entity.Acceleration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AccelerationMapper {

    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "name", target = "name"),
            @Mapping(source = "slug", target = "slug"),
            @Mapping(source = "challenge.id", target = "challengeId"),
            @Mapping(source = "createdAt", target = "createdAt", dateFormat = "yyyy-MM-dd HH:mm")
    })

    AccelerationDTO map(Acceleration acceleration);

    List<AccelerationDTO> map(List<Acceleration> accelerations);
}