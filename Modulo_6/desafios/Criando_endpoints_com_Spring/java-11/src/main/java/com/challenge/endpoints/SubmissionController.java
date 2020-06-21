package com.challenge.endpoints;

import com.challenge.dto.SubmissionDTO;
import com.challenge.mappers.SubmissionMapper;
import com.challenge.service.interfaces.SubmissionServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/submission")
public class SubmissionController {

    @Autowired
    private SubmissionServiceInterface submissionService;

    @Autowired
    private SubmissionMapper submissionMapper;

    @GetMapping
    public ResponseEntity<List<SubmissionDTO>> findByChallengeIdAndAccelerationId(
            @RequestParam(value = "challengeId", required = true, defaultValue = "0") Long challengeId,
            @RequestParam(value = "accelerationId", required = true, defaultValue = "0") Long accelerationId) {
        return ResponseEntity
                .ok()
                .body(submissionMapper.map(submissionService.
                        findByChallengeIdAndAccelerationId(challengeId, accelerationId)));
    }

}
