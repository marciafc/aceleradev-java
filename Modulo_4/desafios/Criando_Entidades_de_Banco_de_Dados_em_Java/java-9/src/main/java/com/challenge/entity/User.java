package com.challenge.entity;

import com.challenge.converter.LocalDateTimeAttributeConverter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "O nome completo é obrigatório")
    @NotBlank(message = "O nome completo é obrigatório")
    @Size(max = 100, message = "O nome completo deve ter no máximo 100 caracteres")
    @Column(length = 100, name = "full_name", nullable = false)
    private String fullName;

    @NotNull(message = "O email é obrigatório")
    @NotBlank(message = "O email é obrigatório")
    @Size(max = 100, message = "O email deve ter no máximo 100 caracteres")
    @Column(length = 100, nullable = false)
    @Email
    private String email;

    @NotNull(message = "O apelido é obrigatório")
    @NotBlank(message = "O apelido é obrigatório")
    @Size(max = 50, message = "O apelido deve ter no máximo 50 caracteres")
    @Column(length = 50, nullable = false)
    private String nickname;

    @NotNull(message = "A senha é obrigatória")
    @NotBlank(message = "A senha é obrigatória")
    @Size(max = 255, message = "A senha deve ter no máximo 255 caracteres")
    @Column(length = 255, nullable = false)
    private String password;

    @CreatedDate
    @Convert(converter = LocalDateTimeAttributeConverter.class)
    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @OneToMany
    @JoinColumn(
            name = "user_id",
            referencedColumnName = "id")
    private List<Candidate> candidates;

    @OneToMany
    @JoinColumn(
            name = "user_id",
            referencedColumnName = "id")
    private List<Submission> submissions;

}
