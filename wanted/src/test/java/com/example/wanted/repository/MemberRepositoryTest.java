package com.example.wanted.repository;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import com.example.wanted.Fixture.MemberFixture;
import com.example.wanted.common.exception.ClientException;
import com.example.wanted.common.exception.exceptionType.MemberExceptionType;
import com.example.wanted.domain.Member;

@ActiveProfiles("test")
@DataJpaTest
class MemberRepositoryTest {
	@Autowired
	private MemberRepository memberRepository;

	@Test
	@DisplayName("Member를 조회할 수 있다")
	void findByIdOrThrowTest() {
		// given
		Member member = Member.createMember(MemberFixture.MEMBER_EMAIL, MemberFixture.MEMBER_NAME,
			MemberFixture.MEMBER_PASSWORD);
		memberRepository.save(member);

		// when
		Member foundMember = memberRepository.findByIdOrThrow(member.getId());

		// then
		assertEquals(foundMember, member);
	}

	@Test
	@DisplayName("없는 id로 Member를 조회할 경우 예외가 발생한다")
	void findByIdOrThrowWithNotExistId() {
		// given
		Long notExistId = 0L;

		// when, then
		assertThat(assertThrows(ClientException.class, () -> memberRepository.findByIdOrThrow(notExistId))
			.getExceptionType()).isEqualTo(MemberExceptionType.NOT_FOUND_MEMBER);
	}

}