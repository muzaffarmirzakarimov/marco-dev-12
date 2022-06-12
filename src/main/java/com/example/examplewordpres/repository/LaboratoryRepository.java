package com.example.examplewordpres.repository;

import com.example.examplewordpres.entity.Laboratory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LaboratoryRepository extends JpaRepository<Laboratory,Long> {

    List<Optional<Laboratory>> findAllByActiveTrue();
}
