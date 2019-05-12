package com.spectral.model.stripe;

public class Payment_method_details {
    private Card card;

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    @Override
    public String toString() {
        return "Payment_method_details{" +
                "card=" + card +
                '}';
    }
}
