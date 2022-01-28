package com.donContainer.web.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "link")
@SQLDelete(sql = "UPDATE link SET deleted = true WHERE id=?")
@Where(clause = "deleted=false")
public class Link {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String url;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "proyect_id", insertable = false, updatable = false)
    private Proyect proyect;

    @Column(name = "proyect_id", nullable = false)
    private Long proyectId;

    private boolean deleted = Boolean.FALSE;

}
