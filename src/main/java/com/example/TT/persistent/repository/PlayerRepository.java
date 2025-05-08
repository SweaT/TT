package com.example.TT.persistent.repository;

import com.example.TT.persistent.model.PlayerEntity;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface PlayerRepository extends JpaRepository<PlayerEntity, UUID> {

    @EntityGraph(attributePaths = {"team"})
    Optional<PlayerEntity> findWithTeamById(UUID id);

}
