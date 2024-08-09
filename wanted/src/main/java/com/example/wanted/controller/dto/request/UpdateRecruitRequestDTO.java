package com.example.wanted.controller.dto.request;

public record UpdateRecruitRequestDTO(
	String position,
	Integer recruitmentBonus,
	String content,
	String techStack) {
}
