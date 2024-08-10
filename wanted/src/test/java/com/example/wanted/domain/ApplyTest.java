package com.example.wanted.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.ActiveProfiles;

import com.example.wanted.Fixture.MemberFixture;
import com.example.wanted.Fixture.RecruitFixture;

@ActiveProfiles("test")
class ApplyTest {
	private Member member;
	private Recruit recruit;

	@Test
	@DisplayName("Apply를 생성할 수 있다")
	void createApplyTest() {
		// given
		member = Member.createMember(MemberFixture.MEMBER_EMAIL, MemberFixture.MEMBER_NAME,
			MemberFixture.MEMBER_PASSWORD);
		recruit = Recruit.createRecruit(RecruitFixture.POSITION, RecruitFixture.RECRUITMENT_BONUS,
			RecruitFixture.TECH_STACK, RecruitFixture.CONTENT, RecruitFixture.COMPANY);

		// when
		Apply apply = Apply.createApply(member, recruit);

		// then
		assertEquals(apply.getMember(), member);
		assertEquals(apply.getRecruit(), recruit);
	}
}