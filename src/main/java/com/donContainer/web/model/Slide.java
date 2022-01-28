package com.donContainer.web.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "slides")
public class Slide {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "image_url")
    private String imageUrl;

    private String text;

    @Column(name = "orden")
    private int order;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "proyect_id", insertable = false, updatable = false)
    private Proyect proyect;

    @Column(name = "proyect_id", nullable = false)
    private Long proyectId;
}
