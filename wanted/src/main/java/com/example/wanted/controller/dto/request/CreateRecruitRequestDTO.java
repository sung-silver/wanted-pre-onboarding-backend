package com.example.wanted.controller.dto.request;

import jakarta.validation.constraints.NotNull;

public record CreateRecruitRequestDTO(
	@NotNull Long companyId,
	@NotNull String position,
	int recruitmentBonus,
	@NotNull String content,
	@NotNull String techStack) {
}
