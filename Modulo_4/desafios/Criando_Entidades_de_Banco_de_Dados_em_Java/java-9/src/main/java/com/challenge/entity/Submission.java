package com.challenge.entity;

import com.challenge.converter.LocalDateTimeAttributeConverter;
import com.challenge.entity.pk.SubmissionPK;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class Submission {

    @EmbeddedId
    private SubmissionPK candidatePK;

    @NotNull(message = "O score é obrigatório")
    @Column(nullable = false)
    private Float score;

    @CreatedDate
    @Convert(converter = LocalDateTimeAttributeConverter.class)
    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;
}
