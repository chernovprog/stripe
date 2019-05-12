package com.spectral.model.stripe;

public class Card {
    private String brand;
    private String country;
    private String description;
    private String exp_month;
    private String exp_year;
    private String funding;
    private String last4;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getExp_month() {
        return exp_month;
    }

    public void setExp_month(String exp_month) {
        this.exp_month = exp_month;
    }

    public String getExp_year() {
        return exp_year;
    }

    public void setExp_year(String exp_year) {
        this.exp_year = exp_year;
    }

    public String getFunding() {
        return funding;
    }

    public void setFunding(String funding) {
        this.funding = funding;
    }

    public String getLast4() {
        return last4;
    }

    public void setLast4(String last4) {
        this.last4 = last4;
    }

    @Override
    public String toString() {
        return "Card{" +
                "brand='" + brand + '\'' +
                ", country='" + country + '\'' +
                ", description='" + description + '\'' +
                ", exp_month='" + exp_month + '\'' +
                ", exp_year='" + exp_year + '\'' +
                ", funding='" + funding + '\'' +
                ", last4='" + last4 + '\'' +
                '}';
    }
}
