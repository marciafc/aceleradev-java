package com.challenge.entity;

import com.challenge.converter.LocalDateTimeAttributeConverter;
import com.challenge.entity.pk.CandidatePK;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class Candidate {

    @EmbeddedId
    private CandidatePK candidatePK;

    @NotNull(message = "O status é obrigatório")
    @Column(nullable = false)
    private Integer status;

    @CreatedDate
    @Convert(converter = LocalDateTimeAttributeConverter.class)
    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

}
