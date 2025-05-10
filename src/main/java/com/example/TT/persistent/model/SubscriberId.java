package com.example.TT.persistent.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Embeddable
@AllArgsConstructor
@NoArgsConstructor
public class SubscriberId {
    @Column(name = "login", nullable = false, length = 64)
    private String login;

    @Column(name = "event", nullable = false)
    private UUID event;
}
