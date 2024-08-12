package com.example.wanted.repository;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import com.example.wanted.Fixture.CompanyFixture;
import com.example.wanted.domain.Company;

@ActiveProfiles("test")
@DataJpaTest
class CompanyRepositoryTest {
	@Autowired
	private CompanyRepository companyRepository;

	@Test
	@DisplayName("Company를 조회할 수 있다")
	void findByIdOrThrowTest() {
		// given
		Company company = Company.createCompany(CompanyFixture.NAME, CompanyFixture.NATION, CompanyFixture.LOCATION);
		companyRepository.save(company);

		// when
		Company foundCompany = companyRepository.findByIdOrThrow(company.getId());

		// then
		assertEquals(foundCompany, company);
	}

	@Test
	@DisplayName("없는 id로 Company를 조회할 경우 예외가 발생한다")
	void findByIdOrThrowWithNotExistId() {
		// given
		Long notExistId = 0L;

		// when, then
		assertThrows(Exception.class, () -> companyRepository.findByIdOrThrow(notExistId));
	}
}