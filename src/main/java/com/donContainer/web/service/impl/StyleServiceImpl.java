package com.donContainer.web.service.impl;

import com.donContainer.web.dto.StyleDTO;
import com.donContainer.web.mapper.StyleMapper;
import com.donContainer.web.model.Style;
import com.donContainer.web.repository.StyleRepository;
import com.donContainer.web.service.IStyleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class StyleServiceImpl implements IStyleService {

    @Autowired
    private StyleRepository styleRepository;

    @Autowired
    private StyleMapper styleMapper;

    private final String STYLE_NOT_FOUND_MESSAGE = "El estilo no existe";

    @Override
    public StyleDTO save(StyleDTO dto) {
        Style styleEntity = styleMapper.styleDto2Entity(dto);
        Style styleSaved = styleRepository.save(styleEntity);
        StyleDTO styleResult = styleMapper.styleEntity2Dto(styleSaved);
        return styleResult;
    }

    @Override
    public StyleDTO update(Long id, StyleDTO dto) {
        Optional<Style> optional = styleRepository.findById(id);
        if (optional.isPresent()) {
            Style styleUpdated = styleMapper.style2Update(optional.get(), dto);
            styleRepository.save(styleUpdated);
            StyleDTO styleResult = styleMapper.styleEntity2Dto(styleUpdated);
            return styleResult;
        } else throw new EntityNotFoundException(STYLE_NOT_FOUND_MESSAGE);
    }

    @Override
    public List<StyleDTO> getAll() {
        List<Style> styleList = styleRepository.findAll();
        List<StyleDTO> styleDTOS = styleMapper.stylesEntity2Dto(styleList);
        return styleDTOS;
    }

    @Override
    public StyleDTO getById(Long id) {
        Style styleEntity = styleRepository.getById(id);
        StyleDTO styleDTO = styleMapper.styleEntity2Dto(styleEntity);
        return styleDTO;
    }

    //Not Soft, just Hard Delete
    @Override
    public void delete(Long id) {
        styleRepository.deleteById(id);
    }
}
