package com.DCFC.MatchTracker.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "match_statistics")
public class MatchStatistics {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "team_stats_id")
    private List<MatchEvent> events;

    @Column(name = "corners")
    private int corners;

    @Column(name = "fouls")
    private int fouls;
}
