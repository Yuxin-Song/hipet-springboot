package com.hipet.hipetspringboot.repository;

import com.hipet.hipetspringboot.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Image, Integer> {
}
