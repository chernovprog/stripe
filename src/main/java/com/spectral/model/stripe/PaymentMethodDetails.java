package com.spectral.model.stripe;

public class PaymentMethodDetails {
    private Card card;

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    @Override
    public String toString() {
        return "PaymentMethodDetails{" +
                "card=" + card +
                '}';
    }
}
