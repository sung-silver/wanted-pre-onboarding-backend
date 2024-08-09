package com.example.wanted.common.vo;

public record RecruitVO(
	Long id,
	String position,
	int recruitmentBonus,
	String content,
	String techStack
) {
	public static RecruitVO of(Long id, String name, String nation, String location, String position, int recruitmentBonus, String content, String techStack) {
		return new RecruitVO(id, name, nation, location, position, recruitmentBonus, content, techStack);
	}
}
