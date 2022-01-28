package com.donContainer.web.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.sql.Timestamp;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "proyect")
@SQLDelete(sql = "UPDATE proyect SET deleted = true WHERE id=?")
@Where(clause = "deleted=false")
public class Proyect {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;

    private String subtitulo;

    private String descripcion;

    private String detalle;

    @Column(name = "timestamp")
    @CreationTimestamp
    private Timestamp timeStamp;

    private boolean deleted = Boolean.FALSE;

//    //CONTAINER O MODULO?
//    @Column(name = "TYPE", nullable = false)
//    private String type;
//
//    //USO DEL CONTAINER O MODULO (Ej. Escolar)
//    @Column(name = "STYLE", nullable = false)
//    private String style;
//
//    //SECCION PAGINA
//    @Column(name = "SECTION", nullable = false)
//    private String section;

//    @Column(name = "HEADER")
//    private Slide header;

    //@OneToMany(mappedBy = "proyectId", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    //private List<Slide> slideList = new ArrayList<>();

    //@OneToMany(mappedBy = "proyectId", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    //private List<Link> linksList = new ArrayList<>();
}
