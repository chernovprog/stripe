package com.spectral.dao;

import com.spectral.model.Transaction;
import com.spectral.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class TransactionDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * Add a tr to the database
     *
     * @param user User object for which we will add transactions
     * @param tr   Transaction model obtained by Webhook
     */

    /*public void addTransaction(User user, Transaction tr) {
        if (user != null) {
            Long id = user.getId();
            if (id != null) {
                try {
                    jdbcTemplate.query(Queries.INSERT_TRANSACTION)
                            .setParameter(1, tr.getAmount())
                            .setParameter(2, tr.getName())
                            .setParameter(3, tr.getPhone())
                            .setParameter(4, tr.getCurrency())
                            .setParameter(5, tr.getCountry())
                            .setParameter(6, tr.getBrand())
                            .setParameter(7, tr.getLast4())
                            .setParameter(8, tr.getExp_month())
                            .setParameter(9, tr.getExp_year())
                            .setParameter(10, tr.getFunding())
                            .setParameter(11, tr.getStatus())
                            .setParameter(12, user.getId()).executeUpdate();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }
    }*/

}
