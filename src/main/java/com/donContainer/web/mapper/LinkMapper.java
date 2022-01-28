package com.donContainer.web.mapper;

import com.donContainer.web.dto.LinkDTO;
import com.donContainer.web.model.Link;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class LinkMapper {

    public Link linkDto2Entity(LinkDTO dto) {
        Link entity = new Link();
        entity.setUrl(dto.getUrl());
        entity.setProyectId(dto.getProyectId());
        return entity;
    }

    public LinkDTO linkEntity2Dto(Link entity) {
        LinkDTO dto = new LinkDTO();
        dto.setId(entity.getId());
        dto.setUrl(entity.getUrl());
        dto.setProyectId(entity.getProyectId());
        return dto;
    }

    public List<Link> linksDto2Entity(List<LinkDTO> linkDTOS) {
        List<Link> linkEntities = new ArrayList<>();
        for (LinkDTO dto : linkDTOS
        ) {
            linkEntities.add(linkDto2Entity(dto));
        }
        return linkEntities;
    }

    public List<LinkDTO> linksEntity2Dto(List<Link> linkEntities) {
        List<LinkDTO> linkDTOS = new ArrayList<>();
        for (Link entity : linkEntities
        ) {
            linkDTOS.add(linkEntity2Dto(entity));
        }
        return linkDTOS;
    }

    public Link link2Update(Link link4Update, LinkDTO dto) {
        link4Update.setUrl(dto.getUrl());
        return link4Update;
    }
}
