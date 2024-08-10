package com.example.wanted.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.ActiveProfiles;

import com.example.wanted.Fixture.CompanyFixture;
import com.example.wanted.Fixture.RecruitFixture;

@ActiveProfiles("test")
class RecruitTest {
	private String position;
	private int recruitmentBonus;
	private String techStack;
	private String content;
	private Company company;

	@Test
	@DisplayName("Recruit를 생성할 수 있다")
	void createRecruitTest() {
		// given
		position = "position";
		recruitmentBonus = 1000000;
		techStack = "techStack";
		content = "content";
		company = CompanyFixture.createCompany();

		// when
		Recruit recruit = Recruit.createRecruit(position, recruitmentBonus, techStack, content, company);

		// then
		assertEquals(recruit.getPosition(), position);
		assertEquals(recruit.getRecruitmentBonus(), recruitmentBonus);
		assertEquals(recruit.getTechStack(), techStack);
		assertEquals(recruit.getContent(), content);
		assertEquals(recruit.getCompany(), company);
	}

	@Test
	@DisplayName("Recruit의 position을 수정할 수 있다")
	void updatePositionTest() {
		// given
		Recruit recruit = RecruitFixture.createRecruit();
		String updatedPosition = "updatedPosition";

		// when
		recruit.updateRecruitInfo(updatedPosition, null, null, null);

		// then
		assertEquals(recruit.getPosition(), updatedPosition);
	}

	@Test
	@DisplayName("Recruit의 recruitmentBonus를 수정할 수 있다")
	void updateRecruitmentBonusTest() {
		// given
		Recruit recruit = RecruitFixture.createRecruit();
		Integer updatedRecruitmentBonus = 2000000;

		// when
		recruit.updateRecruitInfo(null, updatedRecruitmentBonus, null, null);

		// then
		assertEquals(recruit.getRecruitmentBonus(), updatedRecruitmentBonus);
	}

	@Test
	@DisplayName("Recruit의 techStack을 수정할 수 있다")
	void updateTechStackTest() {
		// given
		Recruit recruit = RecruitFixture.createRecruit();
		String updatedTechStack = "updatedTechStack";

		// when
		recruit.updateRecruitInfo(null, null, updatedTechStack, null);

		// then
		assertEquals(recruit.getTechStack(), updatedTechStack);
	}
}