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
	public static RecruitResponseDTO from(RecruitVO recruitVO) {
		return new RecruitResponseDTO(
			recruitVO.recruitId(),
			recruitVO.companyName(),
			recruitVO.nation(),
			recruitVO.location(),
			recruitVO.position(),
			recruitVO.recruitmentBonus(),
			recruitVO.techStack()
		);
	}
}
