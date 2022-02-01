package com.donContainer.web.service;

import com.donContainer.web.dto.SectionDTO;
import com.donContainer.web.model.Section;

import java.util.List;

public interface ISectionService {

    SectionDTO save(SectionDTO dto);

    SectionDTO update(Long id, SectionDTO dto);

    List<SectionDTO> getAll();

    SectionDTO getById(Long id);

    void delete(Long id);

    Section getSectionById(Long id);
}
