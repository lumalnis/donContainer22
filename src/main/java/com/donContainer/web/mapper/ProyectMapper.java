package com.donContainer.web.mapper;

import com.donContainer.web.dto.LinkDTO;
import com.donContainer.web.dto.ProyectDTO;
import com.donContainer.web.model.Link;
import com.donContainer.web.model.Proyect;
import com.donContainer.web.repository.ProyectRepository;
import com.donContainer.web.service.ISectionService;
import com.donContainer.web.service.IStyleService;
import com.donContainer.web.service.ITypeService;
import com.donContainer.web.service.impl.SectionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class ProyectMapper {

    @Autowired
    private IStyleService styleService;

    @Autowired
    private ISectionService sectionService;

    @Autowired
    private ITypeService typeService;

    public Proyect proyectDto2Entity(ProyectDTO dto) {
        Proyect entity = new Proyect();
        entity.setTitulo(dto.getTitulo());
        entity.setSubtitulo(dto.getSubtitulo());
        entity.setDescripcion(dto.getDescripcion());
        entity.setDetalle(dto.getDetalle());
        entity.setSectionId(dto.getSectionId());
        entity.setSection(sectionService.getSectionById(dto.getSectionId()));
        entity.setStyleId(dto.getStyleId());
        entity.setStyle(styleService.getStyleById(dto.getStyleId()));
        entity.setTypeId(dto.getTypeId());
        entity.setType(typeService.getTypeById(dto.getTypeId()));
        return entity;
    }

    public ProyectDTO proyectEntity2Dto(Proyect entity) {
        ProyectDTO dto = new ProyectDTO();
        dto.setId(entity.getId());
        dto.setTitulo(entity.getTitulo());
        dto.setSubtitulo(entity.getSubtitulo());
        dto.setDescripcion(entity.getDescripcion());
        dto.setDetalle(entity.getDetalle());
        dto.setSectionId(entity.getSectionId());
        dto.setStyleId(entity.getStyleId());
        dto.setTypeId(entity.getTypeId());
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
        proyect4Update.setSection(sectionService.getSectionById(dto.getSectionId()));
        proyect4Update.setStyleId(dto.getStyleId());
        proyect4Update.setStyle(styleService.getStyleById(dto.getStyleId()));
        proyect4Update.setTypeId(dto.getTypeId());
        proyect4Update.setType(typeService.getTypeById(dto.getTypeId()));

        return proyect4Update;
    }
}
