package com.example.TT.persistent.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "players")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PlayerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    @Column(name = "name", nullable = false, length = 255)
    private String name;

    @Column(name = "country", length = 255)
    private String country;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "team",
            referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "player_team_fkey"),
            nullable = false
    )
    private TeamEntity team;

    @Column(name = "goals")
    private Integer goals;

}
