package com.challenge.entity;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Candidate {

	@EmbeddedId
	private CandidateId id;

	@Column
	@NotNull
	private Integer status;

	@CreatedDate
	private LocalDateTime createdAt;

	public Candidate() {}

	public Candidate(CandidateId id, @NotNull Integer status, LocalDateTime createdAt) {
		this.id = id;
		this.status = status;
		this.createdAt = createdAt;
	}

	public CandidateId getId() {
		return id;
	}

	public void setId(CandidateId id) {
		this.id = id;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
}
