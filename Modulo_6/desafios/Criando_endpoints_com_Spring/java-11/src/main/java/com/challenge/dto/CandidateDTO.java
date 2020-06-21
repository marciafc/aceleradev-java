package com.challenge.dto;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CandidateDTO {

    private Long userId;

    private Long accelerationId;

    private Long companyId;

    private Integer status;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private String createdAt;

}
