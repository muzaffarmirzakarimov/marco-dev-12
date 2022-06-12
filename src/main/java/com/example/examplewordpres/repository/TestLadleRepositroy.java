package com.example.examplewordpres.repository;

import com.example.examplewordpres.entity.TestLadle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface TestLadleRepositroy extends JpaRepository<TestLadle,Long> {

    @Transactional
    @Modifying
    @Query(value = "select tl.id, name, ladle_id from laboratory l inner join laboratory_ladles ll on l.id = ll.laboratory_id inner join test_ladle tl on ll.ladles_id = tl.id where l.id=?1",nativeQuery = true)
    List<TestLadle> findAllByLadleId(Long id);
}
