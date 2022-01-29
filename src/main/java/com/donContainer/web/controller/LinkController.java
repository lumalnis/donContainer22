package com.donContainer.web.controller;

import com.donContainer.web.dto.LinkDTO;
import com.donContainer.web.dto.ProyectDTO;
import com.donContainer.web.model.Link;
import com.donContainer.web.service.ILinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("links")
public class LinkController {

    @Autowired
    private ILinkService linkService;

    @GetMapping
    public ResponseEntity<List<LinkDTO>> getAll (){
       List<LinkDTO> allLinks = linkService.findAll();
                return ResponseEntity.status(HttpStatus.OK).body(allLinks);
    }

        @GetMapping("/proyect/{idProyect}")
    public ResponseEntity<List<LinkDTO>> getAllByProyect(@PathVariable Long idProyect) {
        List<LinkDTO> allLinksByProyects = linkService.getAllByProyect(idProyect);
        return ResponseEntity.status(HttpStatus.OK).body(allLinksByProyects);
    }

    @PostMapping
    public ResponseEntity<LinkDTO> save(@RequestBody LinkDTO dto) {
        LinkDTO linkSaved = linkService.save(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(linkSaved);
    }

    @PutMapping("/{id}")
    public ResponseEntity<LinkDTO> update(@PathVariable Long id, @RequestBody LinkDTO dto) {
        LinkDTO linkUpdated = linkService.update(id, dto);
        return ResponseEntity.status(HttpStatus.OK).body(linkUpdated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remove(@PathVariable Long id) {
        linkService.remove(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


}
