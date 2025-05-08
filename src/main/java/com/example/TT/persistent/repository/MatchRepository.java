package com.example.TT.persistent.repository;

import com.example.TT.persistent.model.MatchEntity;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface MatchRepository extends JpaRepository<MatchEntity, UUID> {

    @EntityGraph(attributePaths = {"season", "firstTeam", "secondTeam"})
    @Query(value = """
            SELECT m
            FROM MatchEntity m
            WHERE m.firstTeam.id = :teamId OR m.secondTeam.id = :teamId""")
    List<MatchEntity> findMatchEntitiesByFirstTeamOrSecondTeamEagerOnly(@Param("teamId") UUID teamId);

    List<MatchEntity> findMatchEntitiesBySeasonId(@Param("seasonId") Integer seasonId);

}
