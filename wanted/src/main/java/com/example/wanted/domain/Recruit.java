package com.example.wanted.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Recruit {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	private String position;

	@NotNull
	private int recruitmentBonus;

	@NotNull
	private String techStack;

	@NotNull
	private String content;

	@NotNull
	@ManyToOne
	@JoinColumn(name="company_id")
	private Company company;

	private Recruit(String position, int recruitmentBonus, String techStack, String content, Company company){
		this.position = position;
		this.recruitmentBonus = recruitmentBonus;
		this.techStack = techStack;
		this.content = content;
		this.company = company;
	}

	public static Recruit createRecruit(String position, int recruitmentBonus, String techStack, String content, Company company) {
		return new Recruit(position, recruitmentBonus, techStack, content, company);
	}
}
