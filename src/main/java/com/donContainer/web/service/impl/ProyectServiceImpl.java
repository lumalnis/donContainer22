package com.donContainer.web.service.impl;

import com.donContainer.web.dto.ProyectDTO;
import com.donContainer.web.mapper.ProyectMapper;
import com.donContainer.web.model.Proyect;
import com.donContainer.web.repository.ProyectRepository;
import com.donContainer.web.service.IProyectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class ProyectServiceImpl implements IProyectService {

    @Autowired
    private ProyectRepository proyectRepository;

    @Autowired
    private ProyectMapper proyectMapper;


    public ProyectDTO save(ProyectDTO dto) {

        //FALTAN VALIDACIONES

        Proyect proyectEntity = proyectMapper.proyectDto2Entity(dto);
        Proyect proyectSaved = proyectRepository.save(proyectEntity);
        ProyectDTO proyectResult = proyectMapper.proyectEntity2Dto(proyectSaved);

        //proyectEntity.setSoftDelete(false);
        //proyectEntity.setTimeStamp(new Timestamp(System.currentTimeMillis()));

        return proyectResult;
    }

    public List<ProyectDTO> getAll() {
        List<Proyect> proyectEntities = proyectRepository.findAll();
        List<ProyectDTO> proyectDTOS = proyectMapper.proyectsEntity2Dto(proyectEntities);
        return proyectDTOS;
    }

    public ProyectDTO update(ProyectDTO dto) {
        return new ProyectDTO();
    }

    public void remove(Long id) {
        proyectRepository.deleteById(id);
    }


}