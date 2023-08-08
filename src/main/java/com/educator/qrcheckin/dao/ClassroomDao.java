package com.educator.qrcheckin.dao;

import com.educator.qrcheckin.model.Classroom;
import java.util.List;
import java.util.Optional;

public interface ClassroomDao {
    Classroom save(Classroom classroom);

    Optional<Classroom> findById(Long id);

    List<Classroom> findAll();

    void deleteById(Long id);
}
