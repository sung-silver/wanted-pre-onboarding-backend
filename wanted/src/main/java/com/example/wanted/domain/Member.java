package com.example.wanted.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Member {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	private String email;

	@NotNull
	private String name;

	@NotNull
	private String password;

	private Member(String email, String name, String password) {
		this.email = email;
		this.name = name;
		this.password = password;
	}

	public static Member createMember(String email, String name, String password) {
		return new Member(email, name, password);
	}
}
