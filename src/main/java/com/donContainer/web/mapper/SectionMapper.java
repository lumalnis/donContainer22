package com.donContainer.web.mapper;

import com.donContainer.web.dto.LinkDTO;
import com.donContainer.web.dto.SectionDTO;
import com.donContainer.web.model.Link;
import com.donContainer.web.model.Section;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SectionMapper {

    public Section SectionDto2Entity(SectionDTO dto) {
        Section entity = new Section();
        entity.setName(dto.getName());
        return entity;
    }

    public SectionDTO SectionEntity2Dto(Section entity) {
        SectionDTO dto = new SectionDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        return dto;
    }

    public List<Section> SectionsDto2Entity(List<SectionDTO> SectionsDTOS) {

        List<Section> SectionEntities = new ArrayList<>();
        for (SectionDTO dto : SectionsDTOS) {
            SectionEntities.add(SectionDto2Entity(dto));
        }
        return SectionEntities;
    }

    public List<SectionDTO> SectionsEntity2Dto(List<Section> SectionEntities) {

        List<SectionDTO> SectionsDTOS = new ArrayList<>();
        for (Section entity : SectionEntities) {
            SectionsDTOS.add(SectionEntity2Dto(entity));
        }
        return SectionsDTOS;
    }

    public Section section2Update(Section section4Update, SectionDTO dto) {
        section4Update.setName(dto.getName());
        return section4Update;
    }
}
