package com.DCFC.MatchTracker.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "cards")
public class Card extends MatchEvent {

    private CardType cardType;

    protected Card() {
    }

    public Card(Integer id, String player, int minute, CardType cardType) {
        super(id, player, minute);
        this.cardType = cardType;
    }

    public Card(String player, int minute, CardType cardType) {
        super(player, minute);
        this.cardType = cardType;
    }

    public CardType getCardType() {
        return cardType;
    }

    public void setCardType(CardType cardType) {
        this.cardType = cardType;
    }
}
