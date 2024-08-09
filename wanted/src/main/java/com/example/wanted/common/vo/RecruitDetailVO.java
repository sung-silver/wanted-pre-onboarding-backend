package com.example.wanted.common.vo;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import com.example.wanted.domain.Recruit;

public record RecruitDetailVO(
	long recruitId,
	String companyName,
	String nation,
	String location,
	String position,
	int recruitmentBonus,
	String techStack,
	String content,
	List<Long> otherRecruitIds
) {
	public static RecruitDetailVO from(
		final Recruit recruit
	) {
		return new RecruitDetailVO(
			recruit.getId(),
			recruit.getCompany().getName(),
			recruit.getCompany().getNation(),
			recruit.getCompany().getLocation(),
			recruit.getPosition(),
			recruit.getRecruitmentBonus(),
			recruit.getTechStack(),
			recruit.getContent(),
			Optional.ofNullable(recruit.getCompany().getRecruitList())
				.orElse(Collections.emptyList())
				.stream()
				.map(Recruit::getId)
				.filter(id -> !id.equals(recruit.getId()))
				.toList());
	}
}
