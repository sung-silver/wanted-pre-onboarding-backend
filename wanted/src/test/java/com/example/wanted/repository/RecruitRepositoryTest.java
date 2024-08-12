package com.example.wanted.repository;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import com.example.wanted.Fixture.CompanyFixture;
import com.example.wanted.Fixture.RecruitFixture;
import com.example.wanted.common.exception.ClientException;
import com.example.wanted.common.exception.exceptionType.RecruitExceptionType;
import com.example.wanted.domain.Company;
import com.example.wanted.domain.Recruit;

@ActiveProfiles("test")
@DataJpaTest
class RecruitRepositoryTest {
	@Autowired
	private RecruitRepository recruitRepository;

	@Autowired
	private CompanyRepository companyRepository;

	@Test
	@DisplayName("Recruit를 조회할 수 있다")
	void findByIdOrThrowTest() {
		// given
		Company company = Company.createCompany(CompanyFixture.NAME, CompanyFixture.NATION, CompanyFixture.LOCATION);
		companyRepository.save(company);
		Recruit recruit = Recruit.createRecruit(RecruitFixture.POSITION, RecruitFixture.RECRUITMENT_BONUS,
			RecruitFixture.TECH_STACK, RecruitFixture.CONTENT, company);
		recruitRepository.save(recruit);

		// when
		Recruit foundRecruit = recruitRepository.findByIdOrThrow(recruit.getId());

		// then
		assertEquals(foundRecruit, recruit);
	}

	@Test
	@DisplayName("없는 id로 Recruit를 조회할 경우 예외가 발생한다")
	void findByIdOrThrowWithNotExistId() {
		// given
		Long notExistId = 0L;

		// when, then
		assertThat(assertThrows(ClientException.class, () -> recruitRepository.findByIdOrThrow(notExistId))
			.getExceptionType()).isEqualTo(RecruitExceptionType.NOT_FOUND_RECRUIT);
	}

}