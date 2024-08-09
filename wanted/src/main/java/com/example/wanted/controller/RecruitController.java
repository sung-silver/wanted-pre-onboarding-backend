package com.example.wanted.controller;

import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.wanted.common.vo.RecruitIdVO;
import com.example.wanted.controller.dto.request.CreateRecruitRequestDTO;
import com.example.wanted.controller.dto.request.UpdateRecruitRequestDTO;
import com.example.wanted.service.RecruitService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/recruit")
public class RecruitController {
	private final RecruitService recruitService;

	@PostMapping
	public ResponseEntity<Void> createRecruit(@RequestBody @Valid final CreateRecruitRequestDTO dto) {
		RecruitIdVO recruitIdVO = recruitService.createRecruit(dto);
		URI location = ServletUriComponentsBuilder
			.fromCurrentRequest()
			.path("/{id}")
			.buildAndExpand(recruitIdVO.id())
			.toUri();

		return ResponseEntity.created(location).build();
	}

	@PatchMapping("/{recruitId}")
	public ResponseEntity<Void> updateRecruit(@PathVariable final long recruitId,
		@RequestBody @Valid final UpdateRecruitRequestDTO dto) {
		recruitService.updateRecruit(recruitId, dto);
		return ResponseEntity.ok().build();
	}
}
