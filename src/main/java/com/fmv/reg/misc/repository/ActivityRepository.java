package com.fmv.reg.misc.repository;

import java.math.BigDecimal;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fmv.reg.misc.entity.Activity;

public interface ActivityRepository extends JpaRepository<Activity, BigDecimal> {
	
}
