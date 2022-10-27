package com.cobaspring.cobaspring.repositories;

import com.cobaspring.cobaspring.entities.CarEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarImage extends JpaRepository<CarEntity,Integer> {
}
