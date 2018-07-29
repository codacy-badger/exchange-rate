package com.exchangerate.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exchangerate.dto.RateDTO;

public interface RateRepository extends JpaRepository<RateDTO, Long>{

	Optional<RateDTO> findById(Long id);
}