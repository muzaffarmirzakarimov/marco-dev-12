package com.example.examplewordpres.controller;

import com.example.examplewordpres.dto.ApiResponse;
import com.example.examplewordpres.entity.Chemical;
import com.example.examplewordpres.repository.ChemicalRepository;
import com.example.examplewordpres.service.ChemicalService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/moda")
@RequiredArgsConstructor
public class ChemicalController {

    private final ChemicalService xимическаяService;
    private final ChemicalRepository xимическаяRepository;

    @GetMapping("/{name}")
    public ResponseEntity getOneXимическая(@PathVariable String name){
        Optional<Chemical> byId = xимическаяRepository.findById(name);

        if (byId.isPresent()) {
            Chemical xимическая = byId.get();
            return ResponseEntity.ok().body(xимическая);
        }else {
            return ResponseEntity.ok("Not found");
        }
    }
    @PostMapping
    public ResponseEntity save(@RequestBody Chemical xимическая){
        ApiResponse save = xимическаяService.save(xимическая);
        return ResponseEntity.status(save.isSuccess()? 201:409).body("Save");
    }

    @PutMapping("/{name}")
    public ResponseEntity update(@PathVariable("name") String name,@RequestBody Chemical xимическая){
        ApiResponse updete = xимическаяService.updete(name, xимическая);
        return ResponseEntity.status(updete.isSuccess()? 201:409).body("Update!!");
    }

}
