package com.example.examplewordpres.controller;

import com.example.examplewordpres.dto.ApiResponse;
import com.example.examplewordpres.dto.LaboratoryDTO;
import com.example.examplewordpres.dto.WorkerHomeworkDTO;
import com.example.examplewordpres.entity.Laboratory;
import com.example.examplewordpres.repository.LaboratoryRepository;
import com.example.examplewordpres.service.Laboratoryservice;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/laboratory")
@RequiredArgsConstructor
public class LaboratoryController {

    private final LaboratoryRepository laboratoryRepository;
    private final Laboratoryservice laboratoryservice;


    @PreAuthorize("hasAuthority('LABARANT')")
    @PostMapping
    public ResponseEntity save(@RequestBody Laboratory laboratory){
        ApiResponse save = laboratoryservice.save(laboratory);
        return ResponseEntity.status(save.isSuccess()? 201:409).body("Success");
    }



    @PreAuthorize("hasAuthority('LABARANT')")
    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable Long id, @RequestBody LaboratoryDTO laboratoryDTO){
        ApiResponse updete = laboratoryservice.update(id,laboratoryDTO);
        return ResponseEntity.status(updete.isSuccess()? 201:409).body("Success");
    }

    @PreAuthorize("hasAnyAuthority('LABARANT','DIRECTOR')")
    @GetMapping("/{id}")
    public ResponseEntity getOne(@PathVariable Long id){
        Optional<Laboratory> byId = laboratoryRepository.findById(id);
        if (byId.isPresent()) {
            return ResponseEntity.ok().body(byId.get());
        }else {
            return ResponseEntity.ok("Not found data");
        }
    }

    @PreAuthorize("hasAnyAuthority('LABARANT','DIRECTOR')")
    @GetMapping
    public ResponseEntity getAll(){
        List<Optional<Laboratory>> all = laboratoryRepository.findAllByActiveTrue();
        return ResponseEntity.ok().body(all);
    }

    @PreAuthorize("hasAnyAuthority('LABARANT','DIRECTOR')")
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        Optional<Laboratory> byId = laboratoryRepository.findById(id);
        if (byId.isPresent()) {
            Laboratory laboratory = byId.get();
            laboratory.setActive(false);
            laboratoryRepository.save(laboratory);
        }else {
            return ResponseEntity.ok("Not found");
        }
        return ResponseEntity.ok().body(id);
    }

}
