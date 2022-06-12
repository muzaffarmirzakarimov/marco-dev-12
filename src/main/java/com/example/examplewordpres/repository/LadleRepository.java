package com.example.examplewordpres.repository;

import com.example.examplewordpres.entity.Ladle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface LadleRepository extends JpaRepository<Ladle,Long> {

    @Transactional
    @Modifying
    @Query(value = "select l2.id, local_time, moda1, moda2, moda3, moda4, moda5, moda6 from laboratory l inner join laboratory_ladles ll on l.id = ll.laboratory_id inner join test_ladle tl on ll.ladles_id = tl.id inner join ladle l2 on tl.ladle_id = l2.id where l.id=?1",nativeQuery = true)
    List<Ladle> findAllByLadleId(Long id);
}
