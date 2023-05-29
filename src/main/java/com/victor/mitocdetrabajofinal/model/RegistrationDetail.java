package com.victor.mitocdetrabajofinal.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;


/**
 * DETALLE MATRICULA
 * **/
@Data
@Entity
public class RegistrationDetail implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idRegistrationDetail;

    @ManyToOne
    @JoinColumn(name = "id_course", nullable = false, foreignKey = @ForeignKey(name = "FK_REGISTRATION_DETAIL_COURSE") )
    private Course course;
    private String room;

    @ManyToOne
    @JoinColumn(name = "id_registration", foreignKey = @ForeignKey(name = "FK_REGISTRATION_DETAIL"))
    @JsonIgnore
    private Registration registration;

}
