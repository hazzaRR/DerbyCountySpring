package com.DCFC.MatchTracker.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "substitutions")
public class Substitution extends MatchEvent {

    @Column(name = "player_off")
    private String playerOff;

    protected Substitution() {
    }

    public Substitution(Integer id, String player, int minute, String playerOff) {
        super(id, player, minute);
        this.playerOff = playerOff;
    }

    public Substitution(String player, int minute, String playerOff) {
        super(player, minute);
        this.playerOff = playerOff;
    }

    public String getPlayerOff() {
        return playerOff;
    }

    public void setPlayerOff(String playerOff) {
        this.playerOff = playerOff;
    }
}
