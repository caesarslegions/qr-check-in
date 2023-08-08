package com.educator.qrcheckin.model;

import java.time.LocalDateTime;

public class Attendance {

    private Long id;
    private Long userId;
    private Long classroomId;

    //check in time and check out times are stored as LocalDateTime objects

    private LocalDateTime checkInTime;
    private LocalDateTime checkOutTime;

    public Attendance() {
    }

    public Long getId() {
        return id;
    }

    public Long getUserId() {
        return userId;
    }

    public Long getClassroomId() {
        return classroomId;
    }

    public LocalDateTime getCheckInTime() {
        return checkInTime;
    }

    public LocalDateTime getCheckOutTime() {
        return checkOutTime;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setClassroomId(Long classroomId) {
        this.classroomId = classroomId;
    }

    public void setCheckInTime(LocalDateTime checkInTime) {
        this.checkInTime = checkInTime;
    }

    public void setCheckOutTime(LocalDateTime checkOutTime) {
        this.checkOutTime = checkOutTime;
    }
    
}
