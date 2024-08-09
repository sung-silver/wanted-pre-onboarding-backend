package com.example.wanted.controller;

import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.wanted.common.vo.ApplyIdVO;
import com.example.wanted.controller.dto.request.CreateApplyRequestDTO;
import com.example.wanted.service.ApplyService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/applications")
public class ApplyController {
	private final ApplyService applyService;

	public ResponseEntity<Void> createApply(@RequestBody @Valid final CreateApplyRequestDTO request) {
		ApplyIdVO applyIdVO = applyService.createApply(request);
		URI location = ServletUriComponentsBuilder
			.fromCurrentRequest()
			.path("/{id}")
			.buildAndExpand(applyIdVO.id())
			.toUri();

		return ResponseEntity.created(location).build();
	}
}
