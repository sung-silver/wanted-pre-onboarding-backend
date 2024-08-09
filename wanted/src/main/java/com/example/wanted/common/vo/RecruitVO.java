package com.example.wanted.common.vo;

import com.example.wanted.domain.Recruit;

public record RecruitVO(
	Long recruitId,
	String companyName,
	String nation,
	String location,
	String position,
	Integer recruitmentBonus,
	String techStack
) {
	public static RecruitVO from(Recruit recruit) {
		return new RecruitVO(
			recruit.getId(),
			recruit.getCompany().getName(),
			recruit.getCompany().getNation(),
			recruit.getCompany().getLocation(),
			recruit.getPosition(),
			recruit.getRecruitmentBonus(),
			recruit.getTechStack()
		);
	}
}
