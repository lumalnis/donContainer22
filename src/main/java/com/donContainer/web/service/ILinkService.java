package com.donContainer.web.service;

import com.donContainer.web.dto.LinkDTO;
import com.donContainer.web.model.Link;

import java.util.List;

public interface ILinkService {

    LinkDTO save(LinkDTO dto);

    List<LinkDTO> findAll();

    List<LinkDTO> getAllByProyect(Long proyectId);

    void removeFromProyect(Long proyectId);

    LinkDTO update(Long id, LinkDTO dto);

    void remove(Long id);


}
