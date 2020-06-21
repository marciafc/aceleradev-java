package com.challenge.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccelerationDTO {

    private Long id;

    private String name;

    private String slug;

    private Long challengeId;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private String createdAt;
}