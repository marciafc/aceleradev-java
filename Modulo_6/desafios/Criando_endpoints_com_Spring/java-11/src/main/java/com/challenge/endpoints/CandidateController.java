package com.challenge.endpoints;

import com.challenge.dto.CandidateDTO;
import com.challenge.endpoints.exception.ResourceNotFoundException;
import com.challenge.entity.Candidate;
import com.challenge.mappers.CandidateMapper;
import com.challenge.service.interfaces.CandidateServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/candidate")
public class CandidateController {

    @Autowired
    private CandidateServiceInterface candidateService;

    @Autowired
    private CandidateMapper candidateMapper;

    @GetMapping("/{userId}/{companyId}/{accelerationId}")
    public ResponseEntity<CandidateDTO> findById(@PathVariable("userId") Long userId,
                                                @PathVariable("companyId") Long companyId,
                                                @PathVariable("accelerationId") Long accelerationId) {
    return ResponseEntity
                .ok()
                .body(candidateMapper.map(candidateService
                                            .findById(userId, companyId, accelerationId)
                                            .orElse(new Candidate())));
    }

    @GetMapping
    public ResponseEntity<List<CandidateDTO>> findBy(
            @RequestParam(value = "companyId", required = false, defaultValue = "0") Long companyId,
            @RequestParam(value = "accelerationId", required = false, defaultValue = "0") Long accelerationId) {

        List<Candidate> candidates = null;

        if (companyId != 0) {
            candidates = candidateService.findByCompanyId(companyId);

        } else if (accelerationId != 0) {
            candidates = candidateService.findByAccelerationId(accelerationId);
        }

        return ResponseEntity.ok().body(candidateMapper.map(candidates));
    }

}
