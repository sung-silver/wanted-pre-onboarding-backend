package com.example.wanted.domain;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.ActiveProfiles;

@ActiveProfiles("test")
class MemberTest {

	private String email;
	private String name;
	private String password;

	@Test
	@DisplayName("Member를 생성할 수 있다")
	void createMemberTest() {
		// given
		email = "test@example.com";
		name = "euna";
		password = "wanted1234";

		// when
		Member member = Member.createMember(email, name, password);

		// then
		assertThat(member.getEmail()).isEqualTo(email);
		assertThat(member.getName()).isEqualTo(name);
		assertThat(member.getPassword()).isEqualTo(password);
	}
}