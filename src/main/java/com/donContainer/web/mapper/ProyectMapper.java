package com.donContainer.web.mapper;

import com.donContainer.web.dto.LinkDTO;
import com.donContainer.web.dto.ProyectDTO;
import com.donContainer.web.model.Link;
import com.donContainer.web.model.Proyect;
import com.donContainer.web.repository.ProyectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class ProyectMapper {

    public Proyect proyectDto2Entity(ProyectDTO dto) {
        Proyect entity = new Proyect();
        entity.setTitulo(dto.getTitulo());
        entity.setSubtitulo(dto.getSubtitulo());
        entity.setDescripcion(dto.getDescripcion());
        entity.setDetalle(dto.getDetalle());
        return entity;
    }

    public ProyectDTO proyectEntity2Dto(Proyect entity) {
        ProyectDTO dto = new ProyectDTO();
        dto.setId(entity.getId());
        dto.setTitulo(entity.getTitulo());
        dto.setSubtitulo(entity.getSubtitulo());
        dto.setDescripcion(entity.getDescripcion());
        dto.setDetalle(entity.getDetalle());
        return dto;
    }

    public List<Proyect> proyectsDto2Entity(List<ProyectDTO> proyectsDTOS) {

        List<Proyect> proyectEntities = new ArrayList<>();
        for (ProyectDTO dto : proyectsDTOS) {
            proyectEntities.add(proyectDto2Entity(dto));
        }
        return proyectEntities;
    }

    public List<ProyectDTO> proyectsEntity2Dto(List<Proyect> proyectEntities) {

        List<ProyectDTO> proyectsDTOS = new ArrayList<>();
        for (Proyect entity : proyectEntities) {
            proyectsDTOS.add(proyectEntity2Dto(entity));
        }
        return proyectsDTOS;
    }

    public Proyect proyect2Update(Proyect proyect4Update, ProyectDTO dto) {
        proyect4Update.setTitulo(dto.getTitulo());
        proyect4Update.setSubtitulo(dto.getSubtitulo());
        proyect4Update.setDescripcion(dto.getDescripcion());
        proyect4Update.setDetalle(dto.getDetalle());
        proyect4Update.setSectionId(dto.getSectionId());
        return proyect4Update;
    }
}
