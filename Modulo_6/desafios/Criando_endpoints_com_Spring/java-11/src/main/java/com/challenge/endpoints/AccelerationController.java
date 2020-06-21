package com.challenge.endpoints;

import com.challenge.dto.AccelerationDTO;
import com.challenge.endpoints.exception.ResourceNotFoundException;
import com.challenge.entity.Acceleration;
import com.challenge.mappers.AccelerationMapper;
import com.challenge.service.interfaces.AccelerationServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/acceleration")
public class AccelerationController {

    @Autowired
    private AccelerationServiceInterface accelerationService;

    @Autowired
    private AccelerationMapper accelerationMapper;

    @GetMapping("/{id}")
    public ResponseEntity<AccelerationDTO> findById(@PathVariable("id") Long id) {

        return ResponseEntity
                .ok()
                .body(accelerationMapper.map(accelerationService
                                            .findById(id)
                                            .orElseThrow(() ->
                                                new ResourceNotFoundException(Acceleration.class.getName()))));
    }

    @GetMapping
    public ResponseEntity<List<AccelerationDTO>> findByCompanyId(
            @RequestParam(name = "companyId", required = true, defaultValue = "0") Long companyId) {

        return ResponseEntity
                .ok()
                .body(accelerationMapper.map(accelerationService
                                            .findByCompanyId(companyId)));
    }

}
