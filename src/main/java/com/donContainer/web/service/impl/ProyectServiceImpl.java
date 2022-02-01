package com.donContainer.web.service.impl;

import com.donContainer.web.dto.ProyectDTO;
import com.donContainer.web.dto.SlideDTO;
import com.donContainer.web.dto.StyleDTO;
import com.donContainer.web.exceptions.CantSave;
import com.donContainer.web.mapper.ProyectMapper;
import com.donContainer.web.model.Link;
import com.donContainer.web.model.Proyect;
import com.donContainer.web.model.Slide;
import com.donContainer.web.model.Style;
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
    private final String PROYECTS_NOT_EXIST = "No existen proyectos";

    public ProyectDTO save(ProyectDTO dto) {
        //FALTAN VALIDACIONES + TRY AND CATCH
        Proyect proyectEntity = proyectMapper.proyectDto2Entity(dto);
        Proyect proyectSaved = proyectRepository.save(proyectEntity);
        ProyectDTO proyectResult = proyectMapper.proyectEntity2Dto(proyectSaved);
        return proyectResult;

    }

    @Override
    public Proyect getProyectById(Long id) {
        if (!proyectRepository.existsById(id)) {
            throw new EntityNotFoundException(PROYECT_NOT_FOUND_MESSAGE);
        }
        return proyectRepository.getById(id);
    }

    @Override
    public ProyectDTO getById(Long id) {
        Proyect proyectEntity = getProyectById(id);
        ProyectDTO proyectDTO = proyectMapper.proyectEntity2Dto(proyectEntity);
        return proyectDTO;
    }

    public List<ProyectDTO> getAll() {
        if ((proyectRepository.findAll()).isEmpty()) {
            throw new EntityNotFoundException(PROYECTS_NOT_EXIST);
        }
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
        if (!proyectRepository.existsById(id)) {
            throw new EntityNotFoundException(PROYECT_NOT_FOUND_MESSAGE);
        }
        removeLists(id);
        proyectRepository.deleteById(id);
    }

    //PARA ELIMINAR LINKS Y SLIDES ASOCIADOS AL PROYECTO
    public void removeLists(Long id) {
        linkService.removeFromProyect(id);
        //slideService.removeFromProyect(id);
    }


}
