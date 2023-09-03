package com.DCFC.MatchTracker.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "goals")
public class Goal extends MatchEvent {

    protected Goal() {
    }

    public Goal(Integer id, String player, int minute) {
        super(id, player, minute);
    }

    public Goal(String player, int minute) {
        super(player, minute);
    }
}
