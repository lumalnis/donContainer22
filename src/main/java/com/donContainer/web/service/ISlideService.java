package com.donContainer.web.service;

import com.donContainer.web.dto.SlideDTO;

import java.util.List;

public interface ISlideService {

    SlideDTO save(SlideDTO dto);

    SlideDTO update(Long id, SlideDTO dto);

    List<SlideDTO> getAll();

    SlideDTO getById(Long id);

    void delete(Long id);
}
