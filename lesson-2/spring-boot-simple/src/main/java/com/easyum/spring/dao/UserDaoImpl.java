package com.easyum.spring.dao;

import com.easyum.spring.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class UserDaoImpl implements UserDao {
    public static final String selectAllUsers = "select * from users";
    private final JdbcTemplate userJdbcTemplate;

    @Override
    public User findUserByName(String name) {
        return null;
    }

    @Override
    public List<User> findAllUsers() {
        return userJdbcTemplate.query(selectAllUsers, createUser());
    }

    private RowMapper<User> createUser() {
        return ((rs, i) -> new User(rs.getString("first_name"),
                    rs.getString("second_name"),
                    rs.getString("role")
                    ));
    }

    @Override
    public void addUser(User user) {

    }
}
