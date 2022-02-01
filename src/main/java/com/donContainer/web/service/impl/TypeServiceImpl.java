package com.donContainer.web.service.impl;

import com.donContainer.web.dto.TypeDTO;
import com.donContainer.web.mapper.TypeMapper;
import com.donContainer.web.model.Type;
import com.donContainer.web.repository.TypeRepository;
import com.donContainer.web.service.ITypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class TypeServiceImpl implements ITypeService {

    @Autowired
    private TypeRepository typeRepository;

    @Autowired
    private TypeMapper typeMapper;

    private final String TYPE_NOT_FOUND_MESSAGE = "El tipo no existe";
    private final String TYPES_NOT_EXIST = "No existen tipos";

    @Override
    public TypeDTO save(TypeDTO dto) {
        Type typeEntity = typeMapper.typeDto2Entity(dto);
        Type typeSaved = typeRepository.save(typeEntity);
        TypeDTO typeResult = typeMapper.typeEntity2Dto(typeSaved);
        return typeResult;
    }

    @Override
    public TypeDTO update(Long id, TypeDTO dto) {
        Optional<Type> optional = typeRepository.findById(id);
        if (optional.isPresent()) {
            Type typeUpdated = typeMapper.type2Update(optional.get(), dto);
            typeRepository.save(typeUpdated);
            TypeDTO typeResult = typeMapper.typeEntity2Dto(typeUpdated);
            return typeResult;
        } else throw new EntityNotFoundException(TYPE_NOT_FOUND_MESSAGE);
    }

    @Override
    public List<TypeDTO> getAll() {
        if ((typeRepository.findAll()).isEmpty()) {
            throw new EntityNotFoundException(TYPES_NOT_EXIST);
        }
        List<Type> typeList = typeRepository.findAll();
        List<TypeDTO> typeDTOS = typeMapper.typesEntity2Dto(typeList);
        return typeDTOS;
    }

    @Override
    public Type getTypeById(Long id) {
        if (!typeRepository.existsById(id)) {
            throw new EntityNotFoundException(TYPE_NOT_FOUND_MESSAGE);
        }
        return typeRepository.getById(id);
    }

    @Override
    public TypeDTO getById(Long id) {
        Type typeEntity = getTypeById(id);
        TypeDTO typeDTO = typeMapper.typeEntity2Dto(typeEntity);
        return typeDTO;
    }

    //Not Soft, just Hard Delete
    @Override
    public void delete(Long id) {

        if (!typeRepository.existsById(id)) {
            throw new EntityNotFoundException(TYPE_NOT_FOUND_MESSAGE);
        }
        typeRepository.deleteById(id);
    }


}
