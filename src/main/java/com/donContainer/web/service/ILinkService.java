package com.donContainer.web.service;

import com.donContainer.web.dto.LinkDTO;

import java.util.List;

public interface ILinkService {

    LinkDTO save(LinkDTO dto);

    List<LinkDTO> getAllByProyect(Long proyectId);

    List<LinkDTO> getAll();

    LinkDTO update(Long id, LinkDTO dto);

    void remove(Long id);
}
