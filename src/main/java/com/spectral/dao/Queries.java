package com.spectral.dao;

public interface Queries {

    String INSERT_TRANSACTION = "INSERT INTO Transactions (amount, name, phone, currency, country, brand, " +
            "last4, exp_month, exp_year, funding, status, user_id) VALUES (?, ?, ?, ?, ?, ?, ?, " +
            "?, ?, ?, ?, ?)";

    String GET_USER_BY_EMAIL = "SELECT u FROM User AS u WHERE u.email = :email";
}
