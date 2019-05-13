package com.spectral.dao;

import com.spectral.model.Transaction;
import com.spectral.model.User;
import org.hibernate.HibernateException;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
public class TransactionDao {
    @PersistenceContext
    private EntityManager em;

    @Transactional
    public void addTransaction(User user, Transaction transaction) {
        if (user != null) {
            Long id = user.getId();
            System.out.println("id = " + id);
            if (id != null) {
                try {
                    em.createNativeQuery("INSERT INTO Transactions (amount, name, phone, currency, country, brand, " +
                            "last4, exp_month, exp_year, funding, status, user_id) VALUES (:1, :2, :3, :4, :5, :6, :7, " +
                            ":8, :9, :10, :11, :12)")
                            .setParameter("1", transaction.getAmount())
                            .setParameter("2", transaction.getName())
                            .setParameter("3", transaction.getPhone())
                            .setParameter("4", transaction.getCurrency())
                            .setParameter("5", transaction.getCountry())
                            .setParameter("6", transaction.getBrand())
                            .setParameter("7", transaction.getLast4())
                            .setParameter("8", transaction.getExp_month())
                            .setParameter("9", transaction.getExp_year())
                            .setParameter("10", transaction.getFunding())
                            .setParameter("11", transaction.getStatus())
                            .setParameter("12", user.getId()).executeUpdate();

                } catch (HibernateException he) {
                    he.getMessage();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

}
