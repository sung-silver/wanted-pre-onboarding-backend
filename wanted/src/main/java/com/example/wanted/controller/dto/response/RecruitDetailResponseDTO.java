package com.example.wanted.controller.dto.response;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import com.example.wanted.common.vo.RecruitDetailVO;

public record RecruitDetailResponseDTO(
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
	public static RecruitDetailResponseDTO from(
		final RecruitDetailVO recruitDetailVO
	) {
		return new RecruitDetailResponseDTO(
			recruitDetailVO.recruitId(),
			recruitDetailVO.companyName(),
			recruitDetailVO.nation(),
			recruitDetailVO.location(),
			recruitDetailVO.position(),
			recruitDetailVO.recruitmentBonus(),
			recruitDetailVO.techStack(),
			recruitDetailVO.content(),
			Optional.ofNullable(recruitDetailVO.otherRecruitIds())
				.orElse(Collections.emptyList())
		);
	}
}
