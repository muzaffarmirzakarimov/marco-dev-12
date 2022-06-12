package com.example.examplewordpres.repository;

import com.example.examplewordpres.entity.MainPage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MainPageRepository extends JpaRepository<MainPage,Long> {


}
