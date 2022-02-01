package com.donContainer.web.service.impl;

import com.donContainer.web.dto.SlideDTO;
import com.donContainer.web.mapper.SlideMapper;
import com.donContainer.web.model.Slide;
import com.donContainer.web.repository.SlideRepository;
import com.donContainer.web.service.ISlideService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class SlideServiceImpl implements ISlideService {

    @Autowired
    private SlideRepository slideRepository;

    @Autowired
    private SlideMapper slideMapper;

    private final String SLIDE_NOT_FOUND_MESSAGE = "La imagen no existe";

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

    @Override
    public List<SlideDTO> getAll() {
        List<Slide> slideList = slideRepository.findAll();
        List<SlideDTO> slideDTOS = slideMapper.slidesEntity2Dto(slideList);
        return slideDTOS;
    }

    @Override
    public SlideDTO getById(Long id) {
        Slide slideEntity = slideRepository.getById(id);
        SlideDTO slideDTO = slideMapper.slideEntity2Dto(slideEntity);
        return slideDTO;
    }

    //Not Soft, just Hard Delete
    @Override
    public void delete(Long id) {
        slideRepository.deleteById(id);
    }
}
