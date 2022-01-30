package com.donContainer.web.dto;


import com.donContainer.web.model.Link;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class ProyectDTO {

    private Long id;

    private String titulo;

    private String subtitulo;

    private String descripcion;

    private String detalle;

    private Long sectionId;

}