package com.example.TT.persistent.repository;

import com.example.TT.persistent.model.SeasonEntity;
import com.example.TT.persistent.model.TeamEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SeasonRepository extends JpaRepository<SeasonEntity, Integer> {
}
