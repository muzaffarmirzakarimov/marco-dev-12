package com.example.examplewordpres.controller;

import com.example.examplewordpres.dto.ApiResponse;
import com.example.examplewordpres.service.WordService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/word")
@RequiredArgsConstructor
public class WordController {

    private final WordService wordService;

    @PreAuthorize("hasAnyAuthority('LABARANT','DIRECTOR','WORKER')")
    @GetMapping("/{id}")
    public HttpEntity<String> wordGet(@PathVariable List<Long> id) throws IOException {


        ApiResponse apiResponse = wordService.WordWrite(id);


        return ResponseEntity.status(apiResponse.isSuccess()? 201:409).body("ok");
    }
}
