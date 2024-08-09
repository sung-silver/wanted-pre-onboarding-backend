package com.example.wanted.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(uniqueConstraints = {
		@UniqueConstraint(columnNames = {"recruit_id", "member_id"})
})
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Apply {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;

	@NotNull
	@ManyToOne
	@JoinColumn(name = "member_id")
	private Member member;

	@NotNull
	@ManyToOne
	@JoinColumn(name = "recruit_id")
	private Recruit recruit;

	private Apply(Member member, Recruit recruit) {
		this.member = member;
		this.recruit = recruit;
	}

	public static Apply createApply(Member member, Recruit recruit) {
		return new Apply(member, recruit);
	}
}
