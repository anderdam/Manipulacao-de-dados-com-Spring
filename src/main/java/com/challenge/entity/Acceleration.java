package com.challenge.entity;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;


@Data
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Acceleration implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @NotNull
    @Size(max = 100)
    private String name;

    @Column
    @NotNull
    @Size(max = 50)
    private String slug;

    @ManyToOne
    private Challenge challenge;

    @OneToMany(mappedBy = "id.acceleration")
    private List<Candidate> candidates;

    @CreatedDate
    private LocalDateTime createdAt;

    public Acceleration() {}

    public Acceleration(Long id, @NotNull @Size(max = 100) String name, @NotNull @Size(max = 50) String slug, Challenge challenge, LocalDateTime createdAt) {
        this.id = id;
        this.name = name;
        this.slug = slug;
        this.challenge = challenge;
        this.createdAt = createdAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public Challenge getChallenge() {
        return challenge;
    }

    public void setChallenge(Challenge challenge) {
        this.challenge = challenge;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
