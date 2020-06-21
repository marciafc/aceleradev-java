package com.challenge.entity;

import com.challenge.converter.LocalDateTimeAttributeConverter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class Challenge {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "O nome é obrigatório")
    @NotBlank(message = "O nome é obrigatório")
    @Size(max = 100, message = "O nome deve ter no máximo 100 caracteres")
    @Column(length = 100, nullable = false)
    private String name;

    @NotNull(message = "O slug é obrigatório")
    @NotBlank(message = "O slug é obrigatório")
    @Size(max = 50, message = "O slug deve ter no máximo 50 caracteres")
    @Column(length = 50, nullable = false)
    private String slug;

    @CreatedDate
    @Convert(converter = LocalDateTimeAttributeConverter.class)
    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @OneToMany
    @JoinColumn(
            name = "challenge_id",
            referencedColumnName = "id")
    private List<Acceleration> accelerations;

    @OneToMany
    @JoinColumn(
            name = "challenge_id",
            referencedColumnName = "id")
    private List<Submission> submissions;
}
