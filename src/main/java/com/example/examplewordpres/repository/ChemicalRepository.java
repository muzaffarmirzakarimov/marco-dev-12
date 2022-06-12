package com.example.examplewordpres.repository;

import com.example.examplewordpres.entity.Chemical;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ChemicalRepository extends JpaRepository<Chemical,String> {
    Optional<Chemical> findByName(String name);

}
