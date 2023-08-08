package com.educator.qrcheckin.dao;

import com.educator.qrcheckin.model.User;
import java.util.List;
import java.util.Optional;

public interface UserDao {
    User save(User user);

    Optional<User> findById(Long id);

    List<User> findAll();

    void deleteById(Long id);
}
