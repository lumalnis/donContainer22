package com.donContainer.web.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "section")
public class Section {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    //SECCION PAGINA (ALQUILER INSPIRACION PROYECTO)
    private String name;

//    @ManyToOne (fetch = FetchType.EAGER ,cascade = CascadeType.ALL)
//    @JoinColumn (name = "proyecto_id", insertable = false, updatable = false)
//    private Proyect proyecto;
//
//    @Column (name = "proyecto_id", nullable = false)
//    private Long proyectoId;


}
