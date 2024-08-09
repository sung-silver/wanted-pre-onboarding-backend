package com.example.wanted.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.wanted.domain.Recruit;

public interface RecruitRepository extends JpaRepository<Recruit, Long> {

}
