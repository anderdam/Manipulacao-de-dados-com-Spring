package com.challenge.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Data
@EntityListeners(AuditingEntityListener.class)
public class Submission implements Serializable {

    @EmbeddedId
    private SubmissionId id;

    @Column
    @NotNull
    private Float score;

    @CreatedDate
    private LocalDateTime createdAt;

    public Submission() {}

    public Submission(SubmissionId id, @NotNull Float score, LocalDateTime createdAt) {
        this.id = id;
        this.score = score;
        this.createdAt = createdAt;
    }

    public SubmissionId getId() {
        return id;
    }

    public void setId(SubmissionId id) {
        this.id = id;
    }

    public Float getScore() {
        return score;
    }

    public void setScore(Float score) {
        this.score = score;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
