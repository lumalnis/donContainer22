package com.donContainer.web.mapper;

import com.donContainer.web.dto.SlideDTO;
import com.donContainer.web.model.Slide;
import org.springframework.stereotype.Component;


import javax.persistence.EntityNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.UUID;

@Component
public class SlideMapper {

    public Slide slideDto2Entity(SlideDTO dto) {
        Slide entity = new Slide();
        entity.setImageUrl(dto.getImageUrl());
        entity.setText(dto.getText());
        entity.setOrder(dto.getOrder());
        entity.setProyectId(dto.getProyectId());
        return entity;
    }

    public SlideDTO slideEntity2Dto(Slide entity) {
        SlideDTO dto = new SlideDTO();
        dto.setId(entity.getId());
        dto.setImageUrl(entity.getImageUrl());
        dto.setText(entity.getText());
        dto.setOrder(entity.getOrder());
        dto.setProyectId(entity.getProyectId());
        return dto;
    }

    public List<Slide> slidesDto2Entity(List<SlideDTO> SlidesDTOS) {
        List<Slide> slideEntities = new ArrayList<>();
        for (SlideDTO dto : SlidesDTOS) {
            slideEntities.add(slideDto2Entity(dto));
        }
        return slideEntities;
    }

    public List<SlideDTO> slidesEntity2Dto(List<Slide> slideEntities) {

        List<SlideDTO> slidesDTOS = new ArrayList<>();
        for (Slide entity : slideEntities) {
            slidesDTOS.add(slideEntity2Dto(entity));
        }
        return slidesDTOS;
    }

    public Slide slide2Update(Slide slide4Update, SlideDTO dto) {
        slide4Update.setImageUrl(dto.getImageUrl());
        slide4Update.setText(dto.getText());
        slide4Update.setOrder(dto.getOrder());
        slide4Update.setProyectId(dto.getProyectId());
        return slide4Update;
    }


}
