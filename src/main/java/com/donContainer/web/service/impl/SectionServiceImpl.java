package com.donContainer.web.service.impl;

import com.donContainer.web.dto.SectionDTO;
import com.donContainer.web.mapper.SectionMapper;
import com.donContainer.web.model.Section;
import com.donContainer.web.repository.SectionRepository;
import com.donContainer.web.service.ISectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class SectionServiceImpl implements ISectionService {

    @Autowired
    private SectionRepository sectionRepository;

    @Autowired
    private SectionMapper sectionMapper;

    private final String SECTION_NOT_FOUND_MESSAGE = "La sección no existe";

    @Override
    public SectionDTO save(SectionDTO dto) {
        Section sectionEntity = sectionMapper.SectionDto2Entity(dto);
        Section sectionSaved = sectionRepository.save(sectionEntity);
        SectionDTO sectionResult = sectionMapper.SectionEntity2Dto(sectionSaved);
        return sectionResult;
    }

    @Override
    public SectionDTO update(Long id, SectionDTO dto) {
        Optional<Section> optional = sectionRepository.findById(id);
        if (optional.isPresent()) {
            Section sectionUpdated = sectionMapper.section2Update(optional.get(), dto);
            sectionRepository.save(sectionUpdated);
            SectionDTO sectionResult = sectionMapper.SectionEntity2Dto(sectionUpdated);
            return sectionResult;
        } else throw new EntityNotFoundException(SECTION_NOT_FOUND_MESSAGE);
    }

    @Override
    public List<SectionDTO> getAll() {
        List<Section> sectionList = sectionRepository.findAll();
        List<SectionDTO> sectionDTOS = sectionMapper.SectionsEntity2Dto(sectionList);
        return sectionDTOS;
    }

    @Override
    public SectionDTO getById(Long id) {
        Section sectionEntity = sectionRepository.getById(id);
        SectionDTO sectionDTO = sectionMapper.SectionEntity2Dto(sectionEntity);
        return sectionDTO;
    }

    //Not Soft, just Hard Delete
    @Override
    public void delete(Long id) {
        sectionRepository.deleteById(id);
    }
}
