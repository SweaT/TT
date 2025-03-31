package com.example.TT.persistent.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "matches")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MatchEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "season",
            referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "match_season_fkey")
    )
    private SeasonEntity season;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "first_team",
            referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "match_first_team_fkey"),
            nullable = false
    )
    private TeamEntity firstTeam;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "second_team",
            referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "match_second_team_fkey"),
            nullable = false
    )
    private TeamEntity secondTeam;

    @Column(name = "date", nullable = false)
    private LocalDateTime date;

    @Column(name = "score", length = 255)
    private String score;

    @Column(name = "first_team_won")
    private Boolean firstTeamWon;

}
