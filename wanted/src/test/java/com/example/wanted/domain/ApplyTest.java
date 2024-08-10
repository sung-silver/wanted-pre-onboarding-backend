package com.example.wanted.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.ActiveProfiles;

import com.example.wanted.Fixture.MemberFixture;
import com.example.wanted.Fixture.RecruitFixture;

@ActiveProfiles("test")
class ApplyTest {

	@Test
	@DisplayName("Apply를 생성할 수 있다")
	void createApplyTest() {
		// given
		Member member = MemberFixture.createMember();
		Recruit recruit = RecruitFixture.createRecruit();

		// when
		Apply apply = Apply.createApply(member, recruit);

		// then
		assertEquals(apply.getMember(), member);
		assertEquals(apply.getRecruit(), recruit);
	}
}