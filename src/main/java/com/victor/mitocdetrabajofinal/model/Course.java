package com.victor.mitocdetrabajofinal.model;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
public class Course implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 100, nullable = false)
    private String names;

    @Column(length = 100, nullable = false)
    private String initials;

    @Column(length = 1, nullable = false)
    private boolean status;

}
