package com.example.wanted.controller.dto.request;

import jakarta.validation.constraints.NotNull;

public record CreateRecruitDTO(
	@NotNull Long companyId,
	@NotNull String position,
	int recruitmentBonus,
	@NotNull String content,
	@NotNull String techStack) {
}
