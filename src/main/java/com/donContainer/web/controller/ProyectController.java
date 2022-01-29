package com.donContainer.web.controller;

import com.donContainer.web.dto.ProyectDTO;
import com.donContainer.web.service.IProyectService;
import com.fasterxml.jackson.databind.introspect.TypeResolutionContext.Empty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("proyectos")
public class ProyectController {

    @Autowired
    private IProyectService proyectService;

    @GetMapping
    public ResponseEntity<List<ProyectDTO>> getAll(@RequestBody ProyectDTO dto) {
        List allProyects = proyectService.getAll();
        return ResponseEntity.status(HttpStatus.OK).body(allProyects);
    }

    @PostMapping
    public ResponseEntity<ProyectDTO> save(@RequestBody ProyectDTO dto) {
        ProyectDTO proyectSaved = proyectService.save(dto);

        return ResponseEntity.status(HttpStatus.CREATED).body(proyectSaved);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Empty> remove(@PathVariable Long id) {
        proyectService.remove(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}