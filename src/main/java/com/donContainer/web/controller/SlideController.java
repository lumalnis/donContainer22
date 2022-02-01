package com.donContainer.web.controller;

import com.donContainer.web.dto.SlideDTO;
import com.donContainer.web.service.ISlideService;
import com.fasterxml.jackson.databind.introspect.TypeResolutionContext.Empty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("slides")
public class SlideController {

    @Autowired
    private ISlideService slideService;

    @PostMapping
    public ResponseEntity<SlideDTO> save(@RequestBody SlideDTO dto) {
        SlideDTO slideSaved = slideService.save(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(slideSaved);
    }

    @GetMapping
    public ResponseEntity<List<SlideDTO>> findAll() {
        List<SlideDTO> allslides = slideService.getAll();
        return ResponseEntity.status(HttpStatus.OK).body(allslides);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SlideDTO> findByid(@PathVariable Long id) {
        SlideDTO slide = slideService.getById(id);
        return ResponseEntity.status(HttpStatus.OK).body(slide);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SlideDTO> update(@PathVariable Long id, @RequestBody SlideDTO dto) {
        SlideDTO slideUpdated = slideService.update(id, dto);
        return ResponseEntity.status(HttpStatus.OK).body(slideUpdated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Empty> delete(@PathVariable Long id) {
        slideService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
