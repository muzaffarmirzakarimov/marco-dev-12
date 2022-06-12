package com.example.examplewordpres.controller;

import com.example.examplewordpres.dto.ApiResponse;
import com.example.examplewordpres.dto.WorkerHomeworkDTO;
import com.example.examplewordpres.entity.WorkerHomework;
import com.example.examplewordpres.repository.WorkerHomeworkRepository;
import com.example.examplewordpres.service.WorkerHomeworkService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/workerhomework")
@RequiredArgsConstructor
public class WorkerHomeworkController {

    private final WorkerHomeworkService workerHomeworkService;
    private final WorkerHomeworkRepository workerHomeworkRepository;


    @PreAuthorize("hasAuthority('WORKER')")
    @PostMapping
    public ResponseEntity add(@RequestBody WorkerHomework homework){
        ApiResponse save = workerHomeworkService.save(homework);
        return ResponseEntity.status(save.isSuccess()? 201:409).body("Save");
    }


    @PreAuthorize("hasAuthority('WORKER')")
    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable Long id, @RequestBody WorkerHomeworkDTO workerHomeworkDTO){
        ApiResponse updete = workerHomeworkService.updete(id, workerHomeworkDTO);
        return ResponseEntity.status(updete.isSuccess()? 201:409).body("Success");
    }



    @PreAuthorize("hasAnyAuthority('DIRECTOR','WORKER')")
    @GetMapping
    public ResponseEntity getAll(){
        List<Optional<WorkerHomework>> all = workerHomeworkRepository.findAllByActiveTrue();
        return ResponseEntity.ok().body(all);
    }

    @PreAuthorize("hasAnyAuthority('DIRECTOR','WORKER')")
    @GetMapping("/{id}")
    public ResponseEntity getOne(@PathVariable Long id){

        Optional<WorkerHomework> byId = workerHomeworkRepository.findById(id);
        if (byId.isPresent()) {
            return ResponseEntity.ok().body(byId.get());
        }else {
            return ResponseEntity.ok("Not found data");
        }
    }

    @PreAuthorize("hasAnyAuthority('DIRECTOR','WORKER')")
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id){

        Optional<WorkerHomework> byId = workerHomeworkRepository.findById(id);
        if (byId.isPresent()) {
            WorkerHomework workerHomework = byId.get();
            workerHomework.setActive(false);
            workerHomeworkRepository.save(workerHomework);
        }else {
            return ResponseEntity.ok("Not found");
        }
        return ResponseEntity.ok().body(id);
    }

}
