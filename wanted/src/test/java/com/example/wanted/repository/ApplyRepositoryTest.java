package com.example.wanted.repository;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.ActiveProfiles;

import com.example.wanted.Fixture.CompanyFixture;
import com.example.wanted.Fixture.MemberFixture;
import com.example.wanted.Fixture.RecruitFixture;
import com.example.wanted.domain.Apply;
import com.example.wanted.domain.Company;
import com.example.wanted.domain.Member;
import com.example.wanted.domain.Recruit;

@DataJpaTest
@ActiveProfiles("test")
class ApplyRepositoryTest {
	@Autowired
	private ApplyRepository applyRepository;

	@Autowired
	private MemberRepository memberRepository;

	@Autowired
	private RecruitRepository recruitRepository;

	@Autowired
	private CompanyRepository companyRepository;

	@Test
	@DisplayName("Apply를 저장할 수 있다")
	void saveApplyTest() {
		// given
		Member member = Member.createMember(MemberFixture.MEMBER_EMAIL, MemberFixture.MEMBER_NAME,
			MemberFixture.MEMBER_PASSWORD);
		memberRepository.save(member);

		Company company = Company.createCompany(CompanyFixture.NAME, CompanyFixture.NATION, CompanyFixture.LOCATION);
		companyRepository.save(company);

		Recruit recruit = Recruit.createRecruit(RecruitFixture.POSITION, RecruitFixture.RECRUITMENT_BONUS,
			RecruitFixture.TECH_STACK, RecruitFixture.CONTENT, company);
		recruitRepository.save(recruit);

		Apply apply = Apply.createApply(member, recruit);

		// when
		Apply createdApply = applyRepository.save(apply);

		// then
		assertEquals(createdApply.getMember(), member);
		assertEquals(createdApply.getRecruit(), recruit);
	}

	@Test
	@DisplayName("이미 지원한 회원이 같은 채용공고에 대해 지원할 수 없다")
	void saveApplyWithAlreadyAppliedMemberTest() {
		// given
		Member member = Member.createMember(MemberFixture.MEMBER_EMAIL, MemberFixture.MEMBER_NAME,
			MemberFixture.MEMBER_PASSWORD);
		memberRepository.save(member);

		Company company = Company.createCompany(CompanyFixture.NAME, CompanyFixture.NATION, CompanyFixture.LOCATION);
		companyRepository.save(company);

		Recruit recruit = Recruit.createRecruit(RecruitFixture.POSITION, RecruitFixture.RECRUITMENT_BONUS,
			RecruitFixture.TECH_STACK, RecruitFixture.CONTENT, company);
		recruitRepository.save(recruit);

		Apply apply = Apply.createApply(member, recruit);
		applyRepository.save(apply);

		Apply alreadyApply = Apply.createApply(member, recruit);

		// when, then
		assertThrows(DataIntegrityViolationException.class, () -> applyRepository.save(alreadyApply));
	}

}