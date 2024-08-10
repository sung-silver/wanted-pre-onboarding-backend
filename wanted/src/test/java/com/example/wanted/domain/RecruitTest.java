package com.example.wanted.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.ActiveProfiles;

import com.example.wanted.Fixture.CompanyFixture;

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

}