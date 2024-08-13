package com.example.wanted.repository;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

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

	@Test
	@DisplayName("회사 이름으로 Recruit를 조회할 수 있다")
	void findByCompanyNameTest() {
		// given
		Company company1 = Company.createCompany(CompanyFixture.NAME, CompanyFixture.NATION, CompanyFixture.LOCATION);
		companyRepository.save(company1);
		Company company2 = Company.createCompany("원티드", "한국", "서울");
		companyRepository.save(company2);

		Recruit recruit1 = Recruit.createRecruit(RecruitFixture.POSITION, RecruitFixture.RECRUITMENT_BONUS,
			RecruitFixture.TECH_STACK, RecruitFixture.CONTENT, company1);
		recruitRepository.save(recruit1);
		Recruit recruit2 = Recruit.createRecruit("백엔드", 10000, "Spring Boot", "함께 성장할 분들을 기다립니다", company2);
		recruitRepository.save(recruit2);

		// when
		List<Recruit> foundRecruits = recruitRepository.findRecruitsByKeyword(company2.getName());

		// then
		assertEquals(1, foundRecruits.size());
		Recruit foundRecruit = foundRecruits.get(0);
		assertEquals(recruit2.getPosition(), foundRecruit.getPosition());
		assertEquals(recruit2.getRecruitmentBonus(), foundRecruit.getRecruitmentBonus());
		assertEquals(recruit2.getTechStack(), foundRecruit.getTechStack());
		assertEquals(recruit2.getContent(), foundRecruit.getContent());
		assertEquals(company2.getName(), foundRecruit.getCompany().getName());
	}

	@Test
	@DisplayName("직무로 Recruit를 조회할 수 있다")
	void findByPositionTest() {
		// given
		Company company1 = Company.createCompany(CompanyFixture.NAME, CompanyFixture.NATION, CompanyFixture.LOCATION);
		companyRepository.save(company1);
		Company company2 = Company.createCompany("원티드", "한국", "서울");
		companyRepository.save(company2);

		Recruit recruit1 = Recruit.createRecruit(RecruitFixture.POSITION, RecruitFixture.RECRUITMENT_BONUS,
			RecruitFixture.TECH_STACK, RecruitFixture.CONTENT, company1);
		recruitRepository.save(recruit1);
		Recruit recruit2 = Recruit.createRecruit("백엔드", 10000, "Spring Boot", "함께 성장할 분들을 기다립니다", company2);
		recruitRepository.save(recruit2);

		// when
		List<Recruit> foundRecruits = recruitRepository.findRecruitsByKeyword(recruit2.getPosition());

		// then
		assertEquals(1, foundRecruits.size());
		Recruit foundRecruit = foundRecruits.get(0);
		assertEquals(recruit2.getPosition(), foundRecruit.getPosition());
		assertEquals(recruit2.getRecruitmentBonus(), foundRecruit.getRecruitmentBonus());
		assertEquals(recruit2.getTechStack(), foundRecruit.getTechStack());
		assertEquals(recruit2.getContent(), foundRecruit.getContent());
		assertEquals(company2.getName(), foundRecruit.getCompany().getName());
	}

}