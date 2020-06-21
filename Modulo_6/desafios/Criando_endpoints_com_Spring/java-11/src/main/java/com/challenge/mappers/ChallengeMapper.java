package com.challenge.mappers;

import com.challenge.dto.ChallengeDTO;
import com.challenge.entity.Challenge;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ChallengeMapper {

    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "name", target = "name"),
            @Mapping(source = "slug", target = "slug"),
            @Mapping(source = "createdAt", target = "createdAt", dateFormat = "yyyy-MM-dd HH:mm")
    })

    ChallengeDTO map(Challenge challenge);

    List<ChallengeDTO> map(List<Challenge> challenge);
}