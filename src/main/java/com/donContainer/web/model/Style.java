package com.donContainer.web.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "style")
public class Style {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    //USO DEL CONTAINER O MODULO (Ej. ESCOLAR, HOSPITAL, TURISMO, HOTEL, OFICINA, BAÑO, BAR, CARCEL, DEPOSITO, OTROS)
    private String name;
}
