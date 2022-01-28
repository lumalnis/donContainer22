package com.donContainer.web.service.impl;

import com.donContainer.web.dto.LinkDTO;
import com.donContainer.web.mapper.LinkMapper;
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

    private final String ORGANIZATION_NOT_FOUND_MESSAGE = "El link no existe";


    @Override
    public LinkDTO save(LinkDTO dto) {
        Link linkEntity = linkMapper.linkDto2Entity(dto);
        Link linkSaved = linkRepository.save(linkEntity);
        LinkDTO linkResult = linkMapper.linkEntity2Dto(linkSaved);
        return linkResult;
    }

    @Override
    public List<LinkDTO> getAllByProyect(Long proyectId) {
        List<Link> links = linkRepository.findAll();
        List<Link> linksByProyect = links.stream().filter(l -> l.getProyectId() == proyectId).collect(Collectors.toList());
        List<LinkDTO> linksResult = linkMapper.linksEntity2Dto(linksByProyect);
        return linksResult;
    }

    @Override
    public List<LinkDTO> getAll() {
        List<Link> linksEntities = linkRepository.findAll();
        List<LinkDTO> linkDTOS = linkMapper.linksEntity2Dto(linksEntities);
        return linkDTOS;
    }

    @Override
    public LinkDTO update(Long id, LinkDTO dto) {
        Optional<Link> optional = linkRepository.findById(id);
        if (optional.isPresent()) {
            Link linkUpdated = linkMapper.link2Update(optional.get(), dto);
            linkRepository.save(linkUpdated);
            LinkDTO linkResult = linkMapper.linkEntity2Dto(linkUpdated);
            return linkResult;
        } else throw new EntityNotFoundException(ORGANIZATION_NOT_FOUND_MESSAGE);
    }

    @Override
    public void remove(Long id) {
        linkRepository.deleteById(id);
    }
}
