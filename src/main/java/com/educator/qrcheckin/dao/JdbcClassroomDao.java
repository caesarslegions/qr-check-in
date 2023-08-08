package com.educator.qrcheckin.dao;

import com.educator.qrcheckin.model.Classroom;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Repository
public class JdbcClassroomDao implements ClassroomDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcClassroomDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Classroom save(Classroom classroom) {
        String sql = "INSERT INTO classrooms (name, location) VALUES (?, ?)";
        jdbcTemplate.update(sql, classroom.getName(), classroom.getLocation());
        return classroom;
    }

    @Override
    public Optional<Classroom> findById(Long id) {
        String sql = "SELECT * FROM classrooms WHERE id = ?";
        try {
            Classroom classroom = jdbcTemplate.queryForObject(sql, new Object[]{id}, new ClassroomRowMapper());
            return Optional.ofNullable(classroom);
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }

    @Override
    public List<Classroom> findAll() {
        String sql = "SELECT * FROM classrooms";
        return jdbcTemplate.query(sql, new ClassroomRowMapper());
    }

    @Override
    public void deleteById(Long id) {
        String sql = "DELETE FROM classrooms WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }

    private static class ClassroomRowMapper implements RowMapper<Classroom> {
        @Override
        public Classroom mapRow(ResultSet rs, int rowNum) throws SQLException {
            Classroom classroom = new Classroom();
            classroom.setId(rs.getLong("id"));
            classroom.setName(rs.getString("name"));
            classroom.setLocation(rs.getString("location"));
            return classroom;
        }
    }
}
