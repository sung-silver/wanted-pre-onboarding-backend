package com.example.wanted.repository;

import static com.example.wanted.common.exception.exceptionType.CompanyException.*;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.wanted.common.exception.ClientException;
import com.example.wanted.domain.Company;

public interface CompanyRepository extends JpaRepository<Company, Long> {
	default Company findByIdOrThrow(Long companyId) {
		return findById(companyId).orElseThrow(() -> new ClientException(NOT_FOUND_COMPANY));
	}
}
