package com.example.wanted.Fixture;

import com.example.wanted.domain.Company;

public abstract class RecruitFixture {
	public static final String POSITION = "recruitPosition";
	public static final int RECRUITMENT_BONUS = 1000000;
	public static final String TECH_STACK = "recruitTechStack";
	public static final String CONTENT = "recruitContent";
	public static final Company COMPANY = Company.createCompany(CompanyFixture.NAME, CompanyFixture.NATION,
		CompanyFixture.LOCATION);

}
