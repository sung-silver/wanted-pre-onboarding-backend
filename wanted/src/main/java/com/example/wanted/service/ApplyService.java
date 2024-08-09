package com.example.wanted.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.wanted.common.vo.ApplyIdVO;
import com.example.wanted.controller.dto.request.CreateApplyRequestDTO;
import com.example.wanted.domain.Apply;
import com.example.wanted.domain.Member;
import com.example.wanted.domain.Recruit;
import com.example.wanted.repository.ApplyRepository;
import com.example.wanted.repository.MemberRepository;
import com.example.wanted.repository.RecruitRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ApplyService {
	private final ApplyRepository applyRepository;
	private final MemberRepository memberRepository;
	private final RecruitRepository recruitRepository;

	@Transactional
	public ApplyIdVO createApply(CreateApplyRequestDTO request) {
		Member member = memberRepository.findByIdOrThrow(request.memberId());
		Recruit recruit = recruitRepository.findByIdOrThrow(request.recruitId());
		Apply apply = Apply.createApply(member, recruit);
		applyRepository.save(apply);
		return ApplyIdVO.of(apply.getId());
	}
}
