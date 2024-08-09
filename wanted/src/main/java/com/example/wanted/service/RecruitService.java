package com.example.wanted.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.wanted.common.vo.RecruitIdVO;
import com.example.wanted.controller.dto.request.CreateRecruitRequestDTO;
import com.example.wanted.controller.dto.request.UpdateRecruitRequestDTO;
import com.example.wanted.domain.Company;
import com.example.wanted.domain.Recruit;
import com.example.wanted.repository.CompanyRepository;
import com.example.wanted.repository.RecruitRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class RecruitService {
	private final RecruitRepository recruitRepository;
	private final CompanyRepository companyRepository;

	@Transactional
	public RecruitIdVO createRecruit(final CreateRecruitRequestDTO request) {
		Company company = companyRepository.findByIdOrThrow(request.companyId());
		Recruit recruit = Recruit.createRecruit(request.position(), request.recruitmentBonus(), request.techStack(),
			request.content(), company);

		recruitRepository.save(recruit);

		return RecruitIdVO.of(recruit.getId());
	}

	@Transactional
	public void updateRecruit(final long recruitId, final UpdateRecruitRequestDTO request) {
		Recruit recruit = recruitRepository.findByIdOrThrow(recruitId);
		recruit.updateRecruitInfo(request.position(), request.recruitmentBonus(), request.techStack(),
			request.content());
	}
}
