package com.example.TT.persistent.repository;

import com.example.TT.persistent.model.EventEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface EventRepository extends JpaRepository<EventEntity, UUID> {

    @Query("SELECT s.eventEntity FROM SubscriberEntity s WHERE s.user.login = :login")
    List<EventEntity> findAllSubscribedEventsByLogin(@Param("login") String login);


    @Query("SELECT s.eventEntity FROM SubscriberEntity s WHERE s.user.login = :login AND s.eventEntity.isTriggered = 'true'")
    List<EventEntity> findTriggeredEventsByLogin(@Param("login") String login);

}
