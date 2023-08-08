package com.educator.qrcheckin.controller;

import com.educator.qrcheckin.dao.ClassroomDao;
import com.educator.qrcheckin.model.Classroom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/classrooms")
public class ClassroomController {

    private final ClassroomDao classroomDao;

    @Autowired
    public ClassroomController(ClassroomDao classroomDao) {
        this.classroomDao = classroomDao;
    }

    @PostMapping
    public Classroom addClassroom(@RequestBody Classroom classroom) {
        return classroomDao.save(classroom);
    }

    @GetMapping("/{id}")
    public Classroom getClassroom(@PathVariable Long id) {
        return classroomDao.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid classroom Id:" + id));
    }

    @GetMapping
    public List<Classroom> getAllClassrooms() {
        return classroomDao.findAll();
    }

    @DeleteMapping("/{id}")
    public void deleteClassroom(@PathVariable Long id) {
        classroomDao.deleteById(id);
    }


}
