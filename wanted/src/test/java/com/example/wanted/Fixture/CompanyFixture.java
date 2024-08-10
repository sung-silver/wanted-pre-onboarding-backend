package com.example.wanted.Fixture;

import com.example.wanted.domain.Company;

public abstract class CompanyFixture {
	public static final String NAME = "companyName";
	public static final String NATION = "companyNation";
	public static final String LOCATION = "companyLocation";

	public static Company createCompany() {
		return Company.createCompany(NAME, NATION, LOCATION);
	}

}
