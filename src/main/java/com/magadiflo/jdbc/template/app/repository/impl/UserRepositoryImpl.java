package com.magadiflo.jdbc.template.app.repository.impl;

import com.magadiflo.jdbc.template.app.model.User;
import com.magadiflo.jdbc.template.app.repository.IUserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;
import java.util.Optional;

@Repository
public class UserRepositoryImpl implements IUserRepository {
    private static final Logger LOG = LoggerFactory.getLogger(UserRepositoryImpl.class);
    private final JdbcTemplate jdbcTemplate;

    // Expresión Lambda, implementando la interfaz funcional RowMapper
    RowMapper<User> rowMapper = (resultSet, rowNum) -> new User(
            resultSet.getLong("id"),
            resultSet.getString("first_name"),
            resultSet.getString("last_name"),
            resultSet.getString("email")
    );

    public UserRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<User> findAll() {
        String sqlQuery = "SELECT id, first_name, last_name, email FROM users";
        return this.jdbcTemplate.query(sqlQuery, this.rowMapper);
    }

    @Override
    public Optional<User> findById(Long id) {
        String sqlQuery = "SELECT id, first_name, last_name, email FROM users WHERE id = ?";
        User user = null;
        try {
            user = this.jdbcTemplate.queryForObject(sqlQuery, this.rowMapper, id);
        } catch (EmptyResultDataAccessException er) {
            LOG.error("User not found with id: {}", id);
        }
        return Optional.ofNullable(user);
    }

    @Override
    public int save(User user) {
        String sqlQuery = "INSERT INTO users(first_name, last_name, email) VALUES(?,?,?)";
        return this.jdbcTemplate.update(sqlQuery, user.firstName(), user.lastName(), user.email());
    }

    @Override
    public Long saveAndReturnId(User user) {
        String sqlQuery = "INSERT INTO users(first_name, last_name, email) VALUES(?,?,?)";

        /**
         * El objeto keyHolder contendrá el retorno de clave generado automáticamente
         * desde el método update() de JDBCTemplate
         */
        KeyHolder keyHolder = new GeneratedKeyHolder();

        this.jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sqlQuery, Statement.RETURN_GENERATED_KEYS);

            ps.setString(1, user.firstName());
            ps.setString(2, user.lastName());
            ps.setString(3, user.email());

            return ps;
        }, keyHolder);

        return keyHolder.getKey().longValue();
    }

    @Override
    public int update(User user) {
        String sqlQuery = "UPDATE users SET first_name = ?, last_name = ?, email = ? WHERE id = ?";
        return this.jdbcTemplate.update(sqlQuery, user.firstName(), user.lastName(), user.email(), user.id());
    }

    @Override
    public int deleteById(Long id) {
        String sqlQuery = "DELETE FROM users WHERE id = ?";
        return this.jdbcTemplate.update(sqlQuery, id);
    }
}
