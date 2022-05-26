package com.hipet.hipetspringboot.repository;

import com.hipet.hipetspringboot.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Integer> {
    // ATTENTION: ERROR occurs when the table's columns have _, JPA will not look through the words after it!!!
    User findByPhone(String phone);
    boolean existsByPhone(String phone);
}
