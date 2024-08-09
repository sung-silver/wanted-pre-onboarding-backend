package com.example.wanted.repository;

import static com.example.wanted.common.exception.exceptionType.RecruitException.*;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.wanted.common.exception.ClientException;
import com.example.wanted.domain.Recruit;

public interface RecruitRepository extends JpaRepository<Recruit, Long> {
	default Recruit findByIdOrThrow(final Long recruitId) {
		return findById(recruitId).orElseThrow(() -> new ClientException(NOT_FOUND_RECRUIT));
	}
}
