package com.example.wanted.domain;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Company {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	private String name;

	@NotNull
	private String nation;

	@NotNull
	private String location;

	@OneToMany(mappedBy = "company")
	List<Recruit> recruitList;

	private Company(String name, String nation, String location){
		this.name = name;
		this.nation = nation;
		this.location = location;
	}

	public static Company createCompany(String name, String nation, String location) {
		return new Company(name, nation, location);
	}
}
