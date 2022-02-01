package com.donContainer.web.service.impl;

import com.donContainer.web.dto.SlideRequestDTO;
import com.donContainer.web.dto.SlideDTO;
import com.donContainer.web.exceptions.NotFoundExceptions;
import com.donContainer.web.exceptions.ParamNotFound;
import com.donContainer.web.mapper.SlideMapper;
import com.donContainer.web.model.Proyect;
import com.donContainer.web.model.Slide;
import com.donContainer.web.repository.ProyectRepository;
import com.donContainer.web.repository.SlideRepository;
import com.donContainer.web.service.ISlideService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
public class SlideServiceImpl implements ISlideService {

    @Autowired
    private SlideRepository slideRepository;

    @Autowired
    private SlideMapper slideMapper;

    @Autowired
    private ProyectRepository proyectRepository;

    private final String SLIDE_NOT_FOUND_MESSAGE = "La imagen no existe";
    private final String SLIDES_NOT_EXIST = "Las imagenes no existen";

    //----------------------CRUD----------------------
    @Override
    public SlideDTO save(SlideDTO dto) {
        Slide slideEntity = slideMapper.slideDto2Entity(dto);
        Slide slideSaved = slideRepository.save(slideEntity);
        SlideDTO slideResult = slideMapper.slideEntity2Dto(slideSaved);
        return slideResult;
    }

    @Override
    public SlideDTO update(Long id, SlideDTO dto) {
        Optional<Slide> optional = slideRepository.findById(id);
        if (optional.isPresent()) {
            Slide slideUpdated = slideMapper.slide2Update(optional.get(), dto);
            slideRepository.save(slideUpdated);
            SlideDTO slideResult = slideMapper.slideEntity2Dto(slideUpdated);
            return slideResult;
        } else throw new EntityNotFoundException(SLIDE_NOT_FOUND_MESSAGE);
    }

    //Not Soft, just Hard Delete
    @Override
    public void delete(Long id) {
        if (!slideRepository.existsById(id)) {
            throw new EntityNotFoundException(SLIDE_NOT_FOUND_MESSAGE);
        }
        slideRepository.deleteById(id);
    }

    @Override
    public List<SlideDTO> getAll() {
        if (slideRepository.findAll() == null) {
            throw new NotFoundExceptions(SLIDES_NOT_EXIST);
        }
        List<Slide> slideList = slideRepository.findAll();
        List<SlideDTO> slideDTOS = slideMapper.slidesEntity2Dto(slideList);
        //VER SI NO DEBERIA DEVOLVER EL ID
        return slideDTOS;
    }

    @Override
    public Slide getSlideById(Long id) {
        if (!slideRepository.existsById(id)) {
            throw new EntityNotFoundException(SLIDE_NOT_FOUND_MESSAGE);
        }
        return slideRepository.getById(id);
    }

    @Override
    public SlideDTO getById(Long id) {
        Slide slideEntity = getSlideById(id);
        SlideDTO slideDTO = slideMapper.slideEntity2Dto(slideEntity);
        return slideDTO;
    }
    //----------------------CRUD----------------------


    @Override
    public List<SlideRequestDTO> getList(Proyect proyect) {
        if (proyectRepository.findById(proyect.getId()).isPresent()) {

            List<Slide> slideList = slideRepository.findAllByProyectId(proyect);
            slideMapper.slidesEntity2Dto(slideList);
            return null;

        } else {
            throw new EntityNotFoundException(SLIDE_NOT_FOUND_MESSAGE);
        }
    }

    @Override
    public List<SlideRequestDTO> orderList(List<SlideRequestDTO> slide4ListDTO) {
        if (slide4ListDTO == null) {
            throw new NotFoundExceptions(SLIDE_NOT_FOUND_MESSAGE);
        }
        Collections.sort(slide4ListDTO, new Comparator<SlideRequestDTO>() {
            @Override
            public int compare(SlideRequestDTO one, SlideRequestDTO two) {
                return one.getOrder() - two.getOrder();
            }
        });

        return slide4ListDTO;
    }

    private int getSlideOrder(int order) throws ParamNotFound {
        if (order == 0) {
            return slideRepository.getMaxOrder() + 1;
        }
        if (slideRepository.existsByOrder(order)) {
            throw new ParamNotFound("The selected slide order number already exists.");
        }
        return order;
    }
}
