package com.example.wanted.repository;

import static com.example.wanted.common.exception.exceptionType.MemberExceptionType.*;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.wanted.common.exception.ClientException;
import com.example.wanted.domain.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {
	default Member findByIdOrThrow(final Long memberId) {
		return findById(memberId).orElseThrow(() -> new ClientException(NOT_FOUND_MEMBER));
	}
}
