package com.donContainer.web.controller;

import com.donContainer.web.dto.SectionDTO;
import com.donContainer.web.service.ISectionService;
import com.fasterxml.jackson.databind.introspect.TypeResolutionContext.Empty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("sections")
public class SectionController {

    @Autowired
    private ISectionService sectionService;

    @PostMapping
    public ResponseEntity<SectionDTO> save(@RequestBody SectionDTO dto) {
        SectionDTO sectionSaved = sectionService.save(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(sectionSaved);
    }

    @GetMapping
    public ResponseEntity<List<SectionDTO>> findAll() {
        List<SectionDTO> allSections = sectionService.getAll();
        return ResponseEntity.status(HttpStatus.OK).body(allSections);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SectionDTO> findByid(@PathVariable Long id) {
        SectionDTO section = sectionService.getById(id);
        return ResponseEntity.status(HttpStatus.OK).body(section);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SectionDTO> update(@PathVariable Long id, @RequestBody SectionDTO dto) {
        SectionDTO sectionUpdated = sectionService.update(id, dto);
        return ResponseEntity.status(HttpStatus.OK).body(sectionUpdated);
    }

    @DeleteMapping("/{id")
    public ResponseEntity<Empty> delete(Long id) {
        sectionService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
