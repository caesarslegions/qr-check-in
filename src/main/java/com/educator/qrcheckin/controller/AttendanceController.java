package com.educator.qrcheckin.controller;

import com.educator.qrcheckin.dao.AttendanceDao;
import com.educator.qrcheckin.model.Attendance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/attendance")
public class AttendanceController {

    private final AttendanceDao attendanceDao;

    @Autowired
    public AttendanceController(AttendanceDao attendanceDao) {
        this.attendanceDao = attendanceDao;
    }

    @PostMapping
    public void addAttendance(@RequestBody Attendance attendance) {
        attendanceDao.save(attendance);
    }

    @GetMapping("/{id}")
    public List<Attendance> getAttendance(@PathVariable Long id) {
        return attendanceDao.findByUserId(id);
    }

    @GetMapping
    public List<Attendance> getAllAttendance() {
        return attendanceDao.findAll();
    }

    @DeleteMapping("/{id}")
    public void deleteAttendance(@PathVariable Long id) {
        attendanceDao.deleteById(id);
    }


}
