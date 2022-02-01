package com.donContainer.web.mapper;

import com.donContainer.web.dto.Base64MultipartFileDto;
import com.donContainer.web.dto.SlideDTO;
import com.donContainer.web.dto.SlideRequestDTO;
import com.donContainer.web.dto.SlideResponseDTO;
import com.donContainer.web.model.Slide;
import com.donContainer.web.service.IProyectService;
import com.donContainer.web.service.impl.ProyectServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import javax.persistence.EntityNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.UUID;

@Component
public class SlideMapper {

    @Autowired
    private IProyectService proyectService;

    //DEVUELVO ENTIDAD DESDE DTO
    public Slide slideDto2Entity(SlideDTO dto) {
        Slide entity = new Slide();
        entity.setImageUrl(dto.getImageUrl()); //ENCODEIMAGE
        entity.setText(dto.getText());
        entity.setOrder(dto.getOrder());
        entity.setProyectId(proyectService.getProyectById(dto.getProyectId()));
        return entity;
    }

    //DEVUELVO DTO CON TODOS LOS DATOS DESDE ENTIDAD
    public SlideDTO slideEntity2Dto(Slide entity) {
        SlideDTO dto = new SlideDTO();
        dto.setId(entity.getId());
        dto.setImageUrl(entity.getImageUrl());
        dto.setText(entity.getText());
        dto.setOrder(entity.getOrder());
        dto.setProyectId(entity.getProyectId().getId());
        return dto;
    }

    //DEVUELVO ENTIDAD DESDE REQUEST
    public Slide slideDtoRequest2Entity(SlideRequestDTO dto) {
        Slide entity = new Slide();
        entity.setImageUrl(dto.getImageUrl()); //ENCODEIMAGE
        entity.setText(dto.getText());
        entity.setOrder(dto.getOrder());
        entity.setProyectId(proyectService.getProyectById(dto.getProyectId()));
        return entity;
    }

    //DEVUELVO RESPONSE DESDE ENTIDAD
    public SlideResponseDTO slideEntity2ResponseDto(Slide entity) {
        SlideResponseDTO dto = new SlideResponseDTO();
        dto.setImageUrl(entity.getImageUrl());
        dto.setText(entity.getText());
        dto.setOrder(entity.getOrder());
        return dto;
    }

    //MENOS ID DE SLIDE Y PROYECT
    public List<SlideResponseDTO> responseList(List<Slide> slides) {
        List<SlideResponseDTO> responseList = new ArrayList<>();
        for (Slide s : slides
        ) {
            SlideResponseDTO dto = new SlideResponseDTO();
            dto.setImageUrl(s.getImageUrl());
            dto.setText(s.getText());
            dto.setOrder(s.getOrder());
            responseList.add(dto);
        }
        return responseList;
    }

    //MENOS ID DE SLIDE
    public List<SlideRequestDTO> requestList(List<Slide> slides) {
        List<SlideRequestDTO> requestList = new ArrayList<>();
        for (Slide s : slides
        ) {
            SlideRequestDTO dto = new SlideRequestDTO();
            dto.setImageUrl(s.getImageUrl());
            dto.setText(s.getText());
            dto.setOrder(s.getOrder());
            requestList.add(dto);
        }
        return requestList;
    }

    //CON TODOS LOS DATOS
    public List<Slide> slideEntityList(List<SlideRequestDTO> slides) {
        List<Slide> slideList = new ArrayList<>();
        for (SlideRequestDTO dto : slides
        ) {
            Slide slide = new Slide();
            slide.setImageUrl((dto.getImageUrl()));
            slide.setText(dto.getText());
            slide.setOrder(dto.getOrder());
            slideList.add(slide);
        }
        return slideList;
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
        slide4Update.setProyectId(proyectService.getProyectById(dto.getProyectId()));
        return slide4Update;
    }

//    private String encodeImage(String imgUrl) throws EntityNotFoundException, IOException {
//
//        byte[] encoded = Base64.getDecoder().decode(imgUrl);
//        Base64MultipartFileDto file = new Base64MultipartFileDto(encoded);
//        file.setName(UUID.randomUUID().toString() + ".jpg");
//
//        return uploadImageService.uploadImage(file);
//    }


}
