package com.example.examplewordpres.controller;

import com.example.examplewordpres.dto.ApiResponse;
import com.example.examplewordpres.dto.DetailDescriptionDTO;
import com.example.examplewordpres.entity.DetailDescription;
import com.example.examplewordpres.repository.DetailDescriptionRepository;
import com.example.examplewordpres.service.DetailDescriptionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/description")
@RequiredArgsConstructor
public class DetailDescriptionController {

    private final DetailDescriptionRepository detailDescriptionRepository;
    private final DetailDescriptionService detailDescriptionService;

    @PreAuthorize("hasAnyAuthority('WORKER','DIRECTOR')")
    @GetMapping
    public ResponseEntity getAll(){
        List<Optional<DetailDescription>> all = detailDescriptionRepository.findAllByActiveTrue();
        return ResponseEntity.ok().body(all);
    }

    @PreAuthorize("hasAnyAuthority('WORKER','DIRECTOR')")
    @GetMapping("/{id}")
    public ResponseEntity getOne(@PathVariable Long id){
        Optional<DetailDescription> byId = detailDescriptionRepository.findById(id);
        if (byId.isPresent()) {
            return ResponseEntity.ok().body(byId.get());
        }else {
            return ResponseEntity.ok("Not found data");
        }
    }

    @PreAuthorize("hasAuthority('WORKER')")
    @PostMapping
    public ResponseEntity save(@RequestBody DetailDescription detailDescription){

        ApiResponse save =detailDescriptionService.save(detailDescription);
        return ResponseEntity.status(save.isSuccess()? 201:409).body("Save");
    }


    @PreAuthorize("hasAuthority('WORKER')")
    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable Long id, @RequestBody DetailDescriptionDTO dto){
        ApiResponse updete = detailDescriptionService.updete(id, dto);
        return ResponseEntity.status(updete.isSuccess()? 201:409).body("Succsess");
    }

    @PreAuthorize("hasAnyAuthority('WORKER','DIRECTOR')")
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long integer){

        Optional<DetailDescription> byId = detailDescriptionRepository.findById(integer);
        if (byId.isPresent()) {
            DetailDescription detailDescription = byId.get();
            detailDescription.setActive(false);
            detailDescriptionRepository.save(detailDescription);
        }else {
            return ResponseEntity.ok("Not found");
        }
        return ResponseEntity.ok().body(integer);
    }

}
