package com.hipet.hipetspringboot.repository;

import com.hipet.hipetspringboot.entity.Vaccine;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface VaccineRepository extends JpaRepository<Vaccine, Integer> {
    boolean existsByPetid(Integer petid);

    void deleteByPetid(Integer petid);

    Optional<Vaccine> findByPetid(Integer petid);
}
