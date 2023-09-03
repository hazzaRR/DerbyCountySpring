package com.DCFC.MatchTracker.model;

import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class MatchEvent {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "player")
    private String player;

    @Column(name = "min")
    private int minute;

    protected MatchEvent() {
    }

    public MatchEvent(Integer id, String player, int minute) {
        this.id = id;
        this.player = player;
        this.minute = minute;
    }

    public MatchEvent(String player, int minute) {
        this.player = player;
        this.minute = minute;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPlayer() {
        return player;
    }

    public void setPlayer(String player) {
        this.player = player;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }
}
