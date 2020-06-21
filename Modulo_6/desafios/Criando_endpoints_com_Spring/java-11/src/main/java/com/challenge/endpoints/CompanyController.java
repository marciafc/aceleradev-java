package com.challenge.endpoints;

import com.challenge.dto.CompanyDTO;
import com.challenge.endpoints.exception.ResourceNotFoundException;
import com.challenge.entity.Company;
import com.challenge.mappers.CompanyMapper;
import com.challenge.service.interfaces.CompanyServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/company")
public class CompanyController {

    @Autowired
    private CompanyServiceInterface companyService;

    @Autowired
    private CompanyMapper companyMapper;

    @GetMapping("/{id}")
    public ResponseEntity<CompanyDTO> findById(@PathVariable("id") Long id) {
        return ResponseEntity
                .ok()
                .body(companyMapper.map(companyService
                                        .findById(id)
                                        .orElseThrow(() ->
                                                new ResourceNotFoundException(Company.class.getName()))));
    }

    @GetMapping
    public ResponseEntity<List<CompanyDTO>> findBy(
            @RequestParam(value = "userId", required = false, defaultValue = "0") Long userId,
            @RequestParam(value = "accelerationId", required = false, defaultValue = "0") Long accelerationId) {

        List<Company> companies = null;

        if (userId != 0) {
            companies = companyService.findByUserId(userId);

        } else if (accelerationId != 0) {
            companies = companyService.findByAccelerationId(accelerationId);
        }

        return ResponseEntity
                .ok()
                .body(companyMapper.map(companies));
    }

}
