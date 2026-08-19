package com.bikashraja.legacyservice.repository;

import com.bikashraja.legacyservice.model.Customer;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerRepository {

    private final JdbcTemplate jdbcTemplate;

    public CustomerRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Customer findById(long id) {

        String sql = """
                SELECT id, name, status, balance
                FROM customers
                WHERE id = ?
                """;

        return jdbcTemplate.queryForObject(
                sql,
                (resultSet, rowNum) -> new Customer(
                        resultSet.getLong("id"),
                        resultSet.getString("name"),
                        resultSet.getString("status"),
                        resultSet.getBigDecimal("balance")
                ),
                id
        );
    }
}
