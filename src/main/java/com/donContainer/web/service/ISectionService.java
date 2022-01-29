package com.donContainer.web.service;

import com.donContainer.web.dto.SectionDTO;

import java.util.List;

public interface ISectionService {

    SectionDTO save(SectionDTO dto);

    SectionDTO update();

    List<SectionDTO> getAll();

    SectionDTO getById(Long id);

    void remove(Long id);
}
