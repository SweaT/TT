package com.example.TT.persistent.repository;

import com.example.TT.persistent.model.PlayerEntity;
import com.example.TT.persistent.model.SeasonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PlayerRepository extends JpaRepository<PlayerEntity, UUID> {
}
