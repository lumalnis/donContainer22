package com.donContainer.web.mapper;

import com.donContainer.web.dto.ProyectDTO;
import com.donContainer.web.model.Proyect;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

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
}