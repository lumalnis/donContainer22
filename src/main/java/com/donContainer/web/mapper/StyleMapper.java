package com.donContainer.web.mapper;

import com.donContainer.web.dto.StyleDTO;
import com.donContainer.web.model.Style;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class StyleMapper {

    public Style styleDto2Entity(StyleDTO dto) {
        Style entity = new Style();
        entity.setName(dto.getName());
        return entity;
    }

    public StyleDTO styleEntity2Dto(Style entity) {
        StyleDTO dto = new StyleDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        return dto;
    }

    public List<Style> stylesDto2Entity(List<StyleDTO> stylesDTOS) {

        List<Style> styleEntities = new ArrayList<>();
        for (StyleDTO dto : stylesDTOS) {
            styleEntities.add(styleDto2Entity(dto));
        }
        return styleEntities;
    }

    public List<StyleDTO> stylesEntity2Dto(List<Style> styleEntities) {

        List<StyleDTO> stylesDTOS = new ArrayList<>();
        for (Style entity : styleEntities) {
            stylesDTOS.add(styleEntity2Dto(entity));
        }
        return stylesDTOS;
    }

    public Style style2Update(Style style4Update, StyleDTO dto) {
        style4Update.setName(dto.getName());
        return style4Update;
    }
}
