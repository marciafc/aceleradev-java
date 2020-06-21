package com.challenge.mappers;

import com.challenge.dto.CompanyDTO;
import com.challenge.entity.Company;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;
import java.util.Set;

@Mapper(componentModel = "spring")
public interface CompanyMapper {

    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "name", target = "name"),
            @Mapping(source = "slug", target = "slug"),
            @Mapping(source = "createdAt", target = "createdAt", dateFormat = "yyyy-MM-dd HH:mm")

    })
    CompanyDTO map(Company company);

    List<CompanyDTO> map(List<Company> companies);

    List<CompanyDTO> map(Set<Company> companies);
}