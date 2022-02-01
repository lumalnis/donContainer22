package com.donContainer.web.service;

import com.donContainer.web.dto.StyleDTO;
import com.donContainer.web.model.Style;

import java.util.List;

public interface IStyleService {

    StyleDTO save(StyleDTO dto);

    StyleDTO update(Long id, StyleDTO dto);

    List<StyleDTO> getAll();

    StyleDTO getById(Long id);

    void delete(Long id);

    Style getStyleById(Long id);
}
