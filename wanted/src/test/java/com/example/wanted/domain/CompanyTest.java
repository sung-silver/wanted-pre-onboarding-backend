package com.example.wanted.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.ActiveProfiles;

@ActiveProfiles("test")
class CompanyTest {
	String name;
	String nation;
	String location;

	@Test
	@DisplayName("Company를 생성할 수 있다")
	void createCompanyTest() {
		// given
		name = "wanted";
		nation = "korea";
		location = "seoul";

		// when
		Company company = Company.createCompany(name, nation, location);

		// then
		assertEquals(company.getName(), name);
		assertEquals(company.getNation(), nation);
		assertEquals(company.getLocation(), location);
	}

}