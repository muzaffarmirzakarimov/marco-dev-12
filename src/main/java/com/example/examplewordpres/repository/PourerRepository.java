package com.example.examplewordpres.repository;

import com.example.examplewordpres.entity.Pourer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface PourerRepository extends JpaRepository<Pourer,Long> {

    @Transactional
    @Modifying
    @Query(value ="select  p.id, balls, general_massa, kolform, name_castings, note, number, tempera_fills, weight_pcs from detail_description d inner join detail_description_list ddl on d.id = ddl.detail_description_id inner join pourer p on ddl.list_id = p.id where d.id=?1",nativeQuery = true)
    List<Pourer> findAllByPourerId(Long id);

}
