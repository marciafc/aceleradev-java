package com.challenge.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    private Long id;

    private String fullName;

    private String email;

    private String nickname;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private String createdAt;

}