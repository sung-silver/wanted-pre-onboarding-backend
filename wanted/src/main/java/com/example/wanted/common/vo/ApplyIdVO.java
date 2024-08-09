package com.example.wanted.common.vo;

public record ApplyIdVO(long id) {
	public static ApplyIdVO of(long id) {
		return new ApplyIdVO(id);
	}
}
