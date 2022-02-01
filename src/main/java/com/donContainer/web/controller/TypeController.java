package com.donContainer.web.controller;

import com.donContainer.web.dto.TypeDTO;
import com.donContainer.web.service.ITypeService;
import com.fasterxml.jackson.databind.introspect.TypeResolutionContext.Empty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("types")
public class TypeController {

    @Autowired
    private ITypeService typeService;

    @PostMapping
    public ResponseEntity<TypeDTO> save(@RequestBody TypeDTO dto) {
        TypeDTO typeSaved = typeService.save(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(typeSaved);
    }

    @GetMapping
    public ResponseEntity<List<TypeDTO>> findAll() {
        List<TypeDTO> alltypes = typeService.getAll();
        return ResponseEntity.status(HttpStatus.OK).body(alltypes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TypeDTO> findByid(@PathVariable Long id) {
        TypeDTO type = typeService.getById(id);
        return ResponseEntity.status(HttpStatus.OK).body(type);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TypeDTO> update(@PathVariable Long id, @RequestBody TypeDTO dto) {
        TypeDTO typeUpdated = typeService.update(id, dto);
        return ResponseEntity.status(HttpStatus.OK).body(typeUpdated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Empty> delete(@PathVariable Long id) {
        typeService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
