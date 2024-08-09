package com.example.wanted.common.vo;

public record RecruitIdVO(
	Long id
) {
	public static RecruitIdVO of(final Long id) {
		return new RecruitIdVO(id);
	}
}
