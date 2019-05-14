package com.spectral.dao;

import com.spectral.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void addUser(User user) {
        jdbcTemplate.update("INSERT INTO users VALUES(?, ?, ?)", user.getEmail(), user.getName(), user.getPhone());
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
            String query = "SELECT * FROM users WHERE email = ?";
            user = jdbcTemplate.queryForObject(query, new Object[]{"a@gmail.com"}, User.class);
            user = jdbcTemplate.queryForObject(query, new Object[]{"a@gmail.com"}, User.class);
            System.out.println(user);

            /*TypedQuery<User> query = em.createQuery(Queries.GET_USER_BY_EMAIL, User.class);
            query.setParameter("email", email);
            user = query.getSingleResult();*/
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return user;
    }

    public Long getUserId(String email) {
        return 1l;
    }


}
