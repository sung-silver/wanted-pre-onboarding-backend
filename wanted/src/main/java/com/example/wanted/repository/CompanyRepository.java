package com.example.wanted.repository;

import static com.example.wanted.common.exception.exceptionType.CompanyExceptionType.*;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.wanted.common.exception.ClientException;
import com.example.wanted.domain.Company;

public interface CompanyRepository extends JpaRepository<Company, Long> {
	default Company findByIdOrThrow(final Long companyId) {
		return findById(companyId).orElseThrow(() -> new ClientException(NOT_FOUND_COMPANY));
	}
}
