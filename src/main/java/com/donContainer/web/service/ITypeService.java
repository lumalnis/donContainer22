package com.donContainer.web.service;

import com.donContainer.web.dto.TypeDTO;
import com.donContainer.web.model.Type;

import java.util.List;

public interface ITypeService {

    TypeDTO save(TypeDTO dto);

    TypeDTO update(Long id, TypeDTO dto);

    List<TypeDTO> getAll();

    TypeDTO getById(Long id);

    void delete(Long id);

    Type getTypeById(Long id);
}
