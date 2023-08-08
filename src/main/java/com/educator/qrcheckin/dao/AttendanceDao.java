package com.educator.qrcheckin.dao;

import com.educator.qrcheckin.model.Attendance;
import java.util.List;

public interface AttendanceDao {
    Attendance save(Attendance attendance);

    List<Attendance> findByUserId(Long userId);

    List<Attendance> findAll();

    void deleteById(Long id);
}
