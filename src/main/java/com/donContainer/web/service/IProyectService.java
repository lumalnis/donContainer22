package com.donContainer.web.service;

import com.donContainer.web.dto.ProyectDTO;
import com.donContainer.web.model.Proyect;

import java.util.List;

public interface IProyectService {

    //CRUD
    ProyectDTO save(ProyectDTO dto);

    List<ProyectDTO> getAll();

    Proyect getProyectById(Long id);

    ProyectDTO getById(Long id);

    ProyectDTO update(Long id, ProyectDTO dto);

    void remove(Long id);

}
