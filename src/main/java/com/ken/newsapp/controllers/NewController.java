package com.ken.newsapp.controllers;

import com.ken.newsapp.dto.NewDTO;
import com.ken.newsapp.exceptions.NotFoundException;
import com.ken.newsapp.requests.NewsRequest;
import com.ken.newsapp.services.NewService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/news")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class NewController {

    private final NewService newService;

    @PostMapping("/generate")
    public ResponseEntity<Void> generateNews(@RequestBody NewsRequest request) {
        newService.generateNews(request);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<NewDTO>> findAll(){
        return ResponseEntity.ok(newService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<NewDTO> findById(@PathVariable String id) throws NotFoundException {
        return ResponseEntity.ok(newService.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable String id) throws NotFoundException {
        newService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
