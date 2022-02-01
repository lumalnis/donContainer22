package com.donContainer.web.model;


import javax.persistence.*;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "type")
public class Type {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    //CONTAINER O MODULO?
    private String name;

//    @ManyToOne(fetch = FetchType.EAGER ,cascade = CascadeType.ALL)
//    @JoinColumn (name = "proyecto_id", insertable = false, updatable = false)
//    private Proyect proyecto;
//
//    @Column (name = "proyecto_id", nullable = false)
//    private Long proyectoId;

}
