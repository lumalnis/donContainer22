package com.donContainer.web.service.impl;

import com.donContainer.web.dto.ProyectDTO;
import com.donContainer.web.mapper.ProyectMapper;
import com.donContainer.web.model.Link;
import com.donContainer.web.model.Proyect;
import com.donContainer.web.repository.ProyectRepository;
import com.donContainer.web.service.ILinkService;
import com.donContainer.web.service.IProyectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@Service
public class ProyectServiceImpl implements IProyectService {

    @Autowired
    private ProyectRepository proyectRepository;

    @Autowired
    private ProyectMapper proyectMapper;

    @Autowired
    private ILinkService linkService;

    private final String PROYECT_NOT_FOUND_MESSAGE = "El proyecto no existe";

    public ProyectDTO save(ProyectDTO dto) {

        //FALTAN VALIDACIONES

        Proyect proyectEntity = proyectMapper.proyectDto2Entity(dto);
        Proyect proyectSaved = proyectRepository.save(proyectEntity);
        ProyectDTO proyectResult = proyectMapper.proyectEntity2Dto(proyectSaved);
        return proyectResult;
    }

    public List<ProyectDTO> getAll() {
        List<Proyect> proyectEntities = proyectRepository.findAll();
        List<ProyectDTO> proyectDTOS = proyectMapper.proyectsEntity2Dto(proyectEntities);
        return proyectDTOS;
    }

    public ProyectDTO update(Long id, ProyectDTO dto) {
        Optional<Proyect> optional = proyectRepository.findById(id);
        if (optional.isPresent()) {
            Proyect proyectUpdated = proyectMapper.proyect2Update(optional.get(), dto);
            proyectRepository.save(proyectUpdated);
            ProyectDTO proyectResult = proyectMapper.proyectEntity2Dto(proyectUpdated);
            return proyectResult;
        } else throw new EntityNotFoundException(PROYECT_NOT_FOUND_MESSAGE);
    }

    public void remove(Long id) {
        removeLists(id);
        proyectRepository.deleteById(id);
    }

    public void removeLists(Long id) {
        linkService.removeFromProyect(id);
    }


}
