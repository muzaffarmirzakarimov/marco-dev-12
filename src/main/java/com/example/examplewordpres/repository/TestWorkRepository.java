package com.example.examplewordpres.repository;

import com.example.examplewordpres.entity.TestWork;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface TestWorkRepository extends JpaRepository<TestWork,Long> {

    @Transactional
    @Modifying
    @Query(value = "select tw.id, name, nomalum_id from worker_homework wh inner join worker_homework_test_list whtl on wh.id = whtl.worker_homework_id inner join test_work tw on whtl.test_list_id = tw.id where wh.id=?1",nativeQuery = true)
    List<TestWork> getAllByTestWorkId(Long id);
}
