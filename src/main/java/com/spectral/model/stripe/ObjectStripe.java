package com.spectral.model.stripe;

public class ObjectStripe {
    private Integer amount;
    private BillingDetails billing_details;
    private String currency;
    private PaymentMethodDetails payment_method_details;
    private String status;

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public BillingDetails getBilling_details() {
        return billing_details;
    }

    public void setBilling_details(BillingDetails billing_details) {
        this.billing_details = billing_details;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public PaymentMethodDetails getPayment_method_details() {
        return payment_method_details;
    }

    public void setPayment_method_details(PaymentMethodDetails payment_method_details) {
        this.payment_method_details = payment_method_details;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "ObjectStripe{" +
                "amount=" + amount +
                ", billing_details=" + billing_details +
                ", currency='" + currency + '\'' +
                ", payment_method_details=" + payment_method_details +
                ", status='" + status + '\'' +
                '}';
    }
}
