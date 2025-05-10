package com.example.TT.persistent.repository;

import com.example.TT.persistent.model.SubscriberEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SubscriberRepository extends JpaRepository<SubscriberEntity, Long> {

    @Modifying
    @Query(value = """ 
            INSERT INTO subscribers (login, event) VALUES (:login, :event)
            """, nativeQuery = true)
    Integer subscribe(@Param("login") String login, @Param("event") UUID event);

}
