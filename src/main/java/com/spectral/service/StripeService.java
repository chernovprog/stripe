package com.spectral.service;

import com.google.gson.Gson;
import com.spectral.model.Transaction;
import com.spectral.model.stripe.*;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.Event;
import com.stripe.model.WebhookEndpoint;
import com.stripe.net.ApiResource;
import com.sun.org.apache.bcel.internal.generic.I2F;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import spark.Request;
import spark.Response;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Service
public class StripeService {

    @Value("${STRIPE_SECRET_KEY}")
    private String stripeSecretKey;

    @Value("${WebhookEndpoint}")
    private String webhook;

    @PostConstruct
    public void init() {
        Stripe.apiKey = stripeSecretKey;

        /*Map<String, Object> webhookendpointParams = new HashMap<String, Object>();
        webhookendpointParams.put("url", webhook);
        webhookendpointParams.put("enabled_events", Arrays.asList("charge.failed", "charge.succeeded"));

        try {
            WebhookEndpoint endpoint = WebhookEndpoint.create(webhookendpointParams);
        } catch (StripeException e) {
            e.printStackTrace();
        }*/
    }

    public Map<String, Object> getParams() {
        Map<String, Object> params = new HashMap<String, Object>();

        ArrayList<String> paymentMethodTypes = new ArrayList<>();
        paymentMethodTypes.add("card");
        params.put("payment_method_types", paymentMethodTypes);

        ArrayList<HashMap<String, Object>> lineItems = new ArrayList<>();
        HashMap<String, Object> lineItem = new HashMap<String, Object>();
        lineItem.put("name", "Apple iPad");
        lineItem.put("description", "Apple iPad A1954 New 2018 Wi-Fi 4G 32GB");
        lineItem.put("amount", 4499);
        lineItem.put("currency", "usd");
        lineItem.put("quantity", 1);
        lineItems.add(lineItem);
        params.put("line_items", lineItems);

        params.put("success_url", "http://localhost:8080/success");
        params.put("cancel_url", "http://localhost:8080/cancel");

        return params;
    }

    public Boolean saveTransaction(String json) {
        JSONStripe jsonStripe = getJsonStripe(json);
        if (jsonStripe != null) {
            Transaction transaction = getTransactionModel(jsonStripe);

            //continue

            return true;
        }

        return false;
    }

    private JSONStripe getJsonStripe(String json) {
        JSONStripe jsonStripe = null;
        try {
            jsonStripe = new Gson().fromJson(json, JSONStripe.class);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return jsonStripe;
    }

    private Transaction getTransactionModel(JSONStripe jsonStripe) {
        Transaction transaction = new Transaction();

        DataStripe data = jsonStripe.getData();
        if (data != null) {
            ObjectStripe object = data.getObject();
            if (object != null) {
                transaction.setAmount(object.getAmount());
                transaction.setCurrency(object.getCurrency());
                transaction.setStatus(object.getStatus());
                Billing_details billing_details = object.getBilling_details();
                if (billing_details != null) {
                    transaction.setEmail(billing_details.getEmail());
                    transaction.setName(billing_details.getName());
                    transaction.setPhone(billing_details.getPhone());
                }
                Payment_method_details payment_details = object.getPayment_method_details();
                if (payment_details != null) {
                    Card card = payment_details.getCard();
                    if (card != null) {
                        transaction.setBrand(card.getBrand());
                        transaction.setCountry(card.getCountry());
                        transaction.setExp_month(card.getExp_month());
                        transaction.setExp_year(card.getExp_year());
                        transaction.setFunding(card.getFunding());
                        transaction.setLast4(card.getLast4());
                    }
                }
            }
        }

        return transaction;
    }

}
