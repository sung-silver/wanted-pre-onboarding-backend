package com.example.wanted.Fixture;

import com.example.wanted.domain.Member;

public class MemberFixture {
	public static final Long MEMBER_ID = 1L;
	public static final String MEMBER_EMAIL = "memberEmail";
	public static final String MEMBER_NAME = "memberName";
	public static final String MEMBER_PASSWORD = "memberPassword";

	public static Member createMember() {
		return Member.createMember(MEMBER_EMAIL, MEMBER_NAME, MEMBER_PASSWORD);
	}
}
