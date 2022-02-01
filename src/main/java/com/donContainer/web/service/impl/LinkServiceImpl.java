package com.donContainer.web.service.impl;

import com.donContainer.web.dto.LinkDTO;
import com.donContainer.web.dto.ProyectDTO;
import com.donContainer.web.mapper.LinkMapper;
import com.donContainer.web.mapper.ProyectMapper;
import com.donContainer.web.model.Link;
import com.donContainer.web.repository.LinkRepository;
import com.donContainer.web.service.ILinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class LinkServiceImpl implements ILinkService {

    @Autowired
    private LinkRepository linkRepository;

    @Autowired
    private LinkMapper linkMapper;

    @Autowired
    private ProyectMapper proyectMapper;

    private final String LINK_NOT_FOUND_MESSAGE = "El link no existe";
    private final String LINKS_NOT_EXIST = "No existen links";


    @Override
    public LinkDTO save(LinkDTO dto) {
        Link linkEntity = linkMapper.linkDto2Entity(dto);
        Link linkSaved = linkRepository.save(linkEntity);
        LinkDTO linkResult = linkMapper.linkEntity2Dto(linkSaved);
        return linkResult;
    }

    public List<LinkDTO> findAll() {
        if ((linkRepository.findAll()).isEmpty()) {
            throw new EntityNotFoundException(LINKS_NOT_EXIST);
        }
        List<Link> links = linkRepository.findAll();
        List<LinkDTO> dtos = linkMapper.linksEntity2Dto(links);
        return dtos;
    }

    public List<LinkDTO> getAllByProyect(Long proyectId) {
        if ((linkRepository.findAll()).isEmpty()) {
            throw new EntityNotFoundException(LINKS_NOT_EXIST);
        }
        //NO EXISTEN LINKS PARA ESE PROYECTO FALTA!!!
        List<Link> links = linkRepository.findAll();
        List<Link> linksByProyect = links.stream().filter(l -> l.getProyectId() == proyectId).collect(Collectors.toList());
        List<LinkDTO> linksResult = linkMapper.linksEntity2Dto(linksByProyect);
        return linksResult;
    }

    public void removeFromProyect(Long proyectId) {
        List<Link> links = linkRepository.findAll();
        List<Link> linksByProyect = links.stream().filter(l -> l.getProyectId() == proyectId).collect(Collectors.toList());
        for (Link link : linksByProyect) {
            remove(link.getId());
        }
    }

    @Override
    public LinkDTO update(Long id, LinkDTO dto) {
        Optional<Link> optional = linkRepository.findById(id);
        if (optional.isPresent()) {
            Link linkUpdated = linkMapper.link2Update(optional.get(), dto);
            linkRepository.save(linkUpdated);
            LinkDTO linkResult = linkMapper.linkEntity2Dto(linkUpdated);
            return linkResult;
        } else throw new EntityNotFoundException(LINK_NOT_FOUND_MESSAGE);
    }

    @Override
    public void remove(Long id) {
        if (!linkRepository.existsById(id)) {
            throw new EntityNotFoundException(LINK_NOT_FOUND_MESSAGE);
        }
        linkRepository.deleteById(id);
    }
}
