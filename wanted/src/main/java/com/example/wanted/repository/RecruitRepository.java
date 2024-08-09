package com.example.wanted.repository;

import static com.example.wanted.common.exception.exceptionType.RecruitException.*;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.wanted.common.exception.ClientException;
import com.example.wanted.domain.Recruit;

public interface RecruitRepository extends JpaRepository<Recruit, Long> {
	default Recruit findByIdOrThrow(final Long recruitId) {
		return findById(recruitId).orElseThrow(() -> new ClientException(NOT_FOUND_RECRUIT));
	}

	@Query("SELECT r FROM Recruit r WHERE LOWER(r.company.name) LIKE LOWER(CONCAT('%', :keyword, '%')) OR LOWER(r.position) LIKE LOWER(CONCAT('%', :keyword, '%')) OR LOWER(r.techStack) LIKE LOWER(CONCAT('%', :keyword, '%'))")
	List<Recruit> findRecruitsByKeyword(@Param("keyword") final String keyword);
}
