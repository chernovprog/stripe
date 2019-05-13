package com.spectral.dao;

import com.spectral.model.User;
import org.hibernate.HibernateException;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

@Repository
public class UserDao {
    @PersistenceContext
    private EntityManager em;

    @Transactional
    public void addUser(User user) {
        em.persist(user);
    }

    /**
     * Get User from database by email. If there is no such user, we return null
     *
     * @param email
     * @return
     */
    public User getUserByEmail(String email) {
        User user = null;
        try {
            TypedQuery<User> query = em.createQuery(Queries.GET_USER_BY_EMAIL, User.class);
            query.setParameter("email", email);
            user = query.getSingleResult();
        } catch (HibernateException he) {
            he.getMessage();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return user;
    }


}
