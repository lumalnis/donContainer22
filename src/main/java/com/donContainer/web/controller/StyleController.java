package com.donContainer.web.controller;

import com.donContainer.web.dto.StyleDTO;
import com.donContainer.web.service.IStyleService;
import com.fasterxml.jackson.databind.introspect.TypeResolutionContext.Empty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("styles")
public class StyleController {

    @Autowired
    private IStyleService styleService;

    @PostMapping
    public ResponseEntity<StyleDTO> save(@RequestBody StyleDTO dto) {
        StyleDTO styleSaved = styleService.save(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(styleSaved);
    }

    @GetMapping
    public ResponseEntity<List<StyleDTO>> findAll() {
        List<StyleDTO> allstyles = styleService.getAll();
        return ResponseEntity.status(HttpStatus.OK).body(allstyles);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StyleDTO> findByid(@PathVariable Long id) {
        StyleDTO style = styleService.getById(id);
        return ResponseEntity.status(HttpStatus.OK).body(style);
    }

    @PutMapping("/{id}")
    public ResponseEntity<StyleDTO> update(@PathVariable Long id, @RequestBody StyleDTO dto) {
        StyleDTO styleUpdated = styleService.update(id, dto);
        return ResponseEntity.status(HttpStatus.OK).body(styleUpdated);
    }

    @DeleteMapping("/{id")
    public ResponseEntity<Empty> delete(Long id) {
        styleService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
