package com.educator.qrcheckin.dao;

import com.educator.qrcheckin.model.Attendance;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class JdbcAttendanceDao implements AttendanceDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcAttendanceDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Attendance save(Attendance attendance) {
        String sql = "INSERT INTO attendance (user_id, classroom_id, check_in_time, check_out_time) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql, attendance.getUserId(), attendance.getClassroomId(), attendance.getCheckInTime(), attendance.getCheckOutTime());
        return attendance;
    }

    @Override
    public List<Attendance> findByUserId(Long userId) {
        String sql = "SELECT * FROM attendance WHERE user_id = ?";
        return jdbcTemplate.query(sql, new Object[]{userId}, new AttendanceRowMapper());
    }

    @Override
    public List<Attendance> findAll() {
        String sql = "SELECT * FROM attendance";
        return jdbcTemplate.query(sql, new AttendanceRowMapper());
    }

    @Override
    public void deleteById(Long id) {
        String sql = "DELETE FROM attendance WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }

    private static class AttendanceRowMapper implements RowMapper<Attendance> {
        @Override
        public Attendance mapRow(ResultSet rs, int rowNum) throws SQLException {
            Attendance attendance = new Attendance();
            attendance.setId(rs.getLong("id"));
            attendance.setUserId(rs.getLong("user_id"));
            attendance.setClassroomId(rs.getLong("classroom_id"));
            attendance.setCheckInTime(rs.getTimestamp("check_in_time").toLocalDateTime());
            attendance.setCheckOutTime(rs.getTimestamp("check_out_time").toLocalDateTime());
            return attendance;
        }
    }
}
