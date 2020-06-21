package com.challenge.endpoints;

import com.challenge.dto.ChallengeDTO;
import com.challenge.mappers.ChallengeMapper;
import com.challenge.service.interfaces.ChallengeServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/challenge")
public class ChallengeController {

    @Autowired
    private ChallengeServiceInterface challengeService;

    @Autowired
    private ChallengeMapper challengeMapper;

    @GetMapping
    public ResponseEntity<List<ChallengeDTO>> findByAccelerationIdAndUserId(
            @RequestParam(value = "accelerationId", required = true) Long accelerationId,
            @RequestParam(value = "userId", required = true) Long userId) {

        return ResponseEntity
                .ok()
                .body(challengeMapper.map(challengeService
                                        .findByAccelerationIdAndUserId(accelerationId, userId)));
    }
}
