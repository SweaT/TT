package com.example.TT.persistent.repository;

import com.example.TT.persistent.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, String> {

    Optional<UserEntity> findByName(String name);

    Optional<UserEntity> findByLogin(String login);

    UserEntity save (UserEntity user);


}
