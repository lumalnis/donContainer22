package com.donContainer.web.mapper;

import com.donContainer.web.dto.TypeDTO;
import com.donContainer.web.model.Type;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TypeMapper {

    public Type typeDto2Entity(TypeDTO dto) {
        Type entity = new Type();
        entity.setName(dto.getName());
        return entity;
    }

    public TypeDTO typeEntity2Dto(Type entity) {
        TypeDTO dto = new TypeDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        return dto;
    }

    public List<Type> typesDto2Entity(List<TypeDTO> typesDTOS) {

        List<Type> typeEntities = new ArrayList<>();
        for (TypeDTO dto : typesDTOS) {
            typeEntities.add(typeDto2Entity(dto));
        }
        return typeEntities;
    }

    public List<TypeDTO> typesEntity2Dto(List<Type> typeEntities) {

        List<TypeDTO> typesDTOS = new ArrayList<>();
        for (Type entity : typeEntities) {
            typesDTOS.add(typeEntity2Dto(entity));
        }
        return typesDTOS;
    }

    public Type type2Update(Type type4Update, TypeDTO dto) {
        type4Update.setName(dto.getName());
        return type4Update;
    }
}
