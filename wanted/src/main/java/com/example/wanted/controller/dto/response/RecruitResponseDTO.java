package com.example.wanted.controller.dto.response;

import com.example.wanted.common.vo.RecruitVO;

public record RecruitResponseDTO(
	Long recruitId,
	String companyName,
	String nation,
	String location,
	String position,
	Integer recruitmentBonus,
	String techStack
) {
	public static RecruitResponseDTO from(RecruitVO recruit) {
		return new RecruitResponseDTO(
			recruit.recruitId(),
			recruit.companyName(),
			recruit.nation(),
			recruit.location(),
			recruit.position(),
			recruit.recruitmentBonus(),
			recruit.techStack()
		);
	}
}
