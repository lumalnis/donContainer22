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
import java.util.ArrayList;
import java.util.List;

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

    //SECTION
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "section", insertable = false, updatable = false)
    private Section section;

    @Column(name = "section_id", nullable = false)
    private Long sectionId;

    //STYLE
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "style", insertable = false, updatable = false)
    private Style style;

    @Column(name = "style_id", nullable = false)
    private Long styleId;

    //TYPE
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "type", insertable = false, updatable = false)
    private Type type;

    @Column(name = "type_id", nullable = false)
    private Long typeId;

    //SLIDE
    @OneToMany(mappedBy = "proyectId", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Slide> slideList = new ArrayList<>();

    @Column(name = "timestamp")
    @CreationTimestamp
    private Timestamp timeStamp;

    private boolean deleted = Boolean.FALSE;
}
