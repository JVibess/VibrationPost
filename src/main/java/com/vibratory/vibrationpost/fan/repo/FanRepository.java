package com.vibratory.vibrationpost.fan.repo;

import com.vibratory.vibrationpost.fan.model.Fan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FanRepository extends JpaRepository<Fan,Long> {
}
