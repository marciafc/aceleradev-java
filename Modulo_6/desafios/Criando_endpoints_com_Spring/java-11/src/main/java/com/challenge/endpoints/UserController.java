package com.challenge.endpoints;

import com.challenge.dto.UserDTO;
import com.challenge.endpoints.exception.ResourceNotFoundException;
import com.challenge.entity.User;
import com.challenge.mappers.UserMapper;
import com.challenge.service.interfaces.UserServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserServiceInterface userService;

    @Autowired
    private UserMapper userMapper;

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable("id") Long id) {

        return ResponseEntity
                .ok()
                .body(userMapper.map(userService
                                    .findById(id)
                                    .orElseThrow(() ->
                                            new ResourceNotFoundException(User.class.getName()))));
    }

    @GetMapping
    public ResponseEntity<List<UserDTO>> findBy(
            @RequestParam(value = "companyId", required = false, defaultValue = "0") Long companyId,
            @RequestParam(value = "accelerationName", required = false, defaultValue = "") String accelerationName) {

        List<User> users = null;

        if (companyId != 0) {
            users = userService.findByCompanyId(companyId);

        } else if (!accelerationName.isEmpty()) {
            users = userService.findByAccelerationName(accelerationName);
        }

        return ResponseEntity.ok().body(userMapper.map(users));
    }
}
