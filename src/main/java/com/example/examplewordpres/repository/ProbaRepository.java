package com.example.examplewordpres.repository;

import com.example.examplewordpres.entity.Ladle;
import com.example.examplewordpres.entity.Proba;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface ProbaRepository extends JpaRepository<Proba,Long> {

    @Transactional
    @Modifying
    @Query(value = "select p.id, local_time, moda1, moda2, moda3, moda4, moda5, moda6 from laboratory l inner join laboratory_probas lp on l.id = lp.laboratory_id inner join test_proba tp on lp.probas_id = tp.id inner join proba p on tp.proba_id = p.id where l.id=?1",nativeQuery = true)
    List<Ladle> findAllByProbaId(Long id);
}
