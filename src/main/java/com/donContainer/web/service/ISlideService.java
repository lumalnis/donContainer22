package com.donContainer.web.service;

import com.donContainer.web.dto.SlideRequestDTO;
import com.donContainer.web.dto.SlideDTO;
import com.donContainer.web.model.Proyect;
import com.donContainer.web.model.Slide;

import java.util.List;

public interface ISlideService {

    SlideDTO save(SlideDTO dto);

    SlideDTO update(Long id, SlideDTO dto);

    List<SlideDTO> getAll();

    Slide getSlideById(Long id);

    SlideDTO getById(Long id);

    void delete(Long id);

    List<SlideRequestDTO> getList(Proyect proyect);

    List<SlideRequestDTO> orderList(List<SlideRequestDTO> slide4ListDTO);

}
