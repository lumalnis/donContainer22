package com.donContainer.web.service;

import com.donContainer.web.dto.StyleDTO;

import java.util.List;

public interface IStyleService {

    StyleDTO save(StyleDTO dto);

    StyleDTO update(Long id, StyleDTO dto);

    List<StyleDTO> getAll();

    StyleDTO getById(Long id);

    void delete(Long id);
}
