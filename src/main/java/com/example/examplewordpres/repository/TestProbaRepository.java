package com.example.examplewordpres.repository;

import com.example.examplewordpres.entity.TestLadle;
import com.example.examplewordpres.entity.TestProba;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface TestProbaRepository extends JpaRepository<TestProba,Long> {


    @Transactional
    @Modifying
    @Query(value = "select tp.id, name, proba_id from laboratory l inner join laboratory_probas lp on l.id = lp.laboratory_id inner join test_proba tp on lp.probas_id = tp.id where l.id=?1",nativeQuery = true)
    List<TestProba> findAllByProbaId(Long id);
}
