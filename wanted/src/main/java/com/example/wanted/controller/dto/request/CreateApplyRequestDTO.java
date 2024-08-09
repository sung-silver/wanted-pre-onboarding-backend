package com.example.wanted.controller.dto.request;

import jakarta.validation.constraints.NotNull;

public record CreateApplyRequestDTO(
	@NotNull long memberId,
	@NotNull long recruitId
) {
}
