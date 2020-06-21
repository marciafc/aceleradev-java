package com.challenge.dto;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubmissionDTO {

    private Long challengeId;

    private String userId;

    private BigDecimal score;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private String createdAt;

}
