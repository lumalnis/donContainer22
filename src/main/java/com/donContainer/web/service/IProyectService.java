package com.donContainer.web.service;

import com.donContainer.web.dto.ProyectDTO;

import java.util.List;

public interface IProyectService {

    //CRUD
    ProyectDTO save (ProyectDTO dto);

    List<ProyectDTO> getAll ();

    ProyectDTO update (Long id, ProyectDTO dto);

    void remove (Long id);

    }
