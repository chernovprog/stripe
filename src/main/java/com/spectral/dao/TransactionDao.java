package com.spectral.dao;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class TransactionDao {
    @PersistenceContext
    private EntityManager entityManager;
}
