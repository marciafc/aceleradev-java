package com.challenge.endpoints.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResourceNotFoundException extends RuntimeException implements Serializable {

    private String resourceName;

    public String getMessage() {
        return "Recurso: " + resourceName + " solicitado não encontrado.";
    }

}
