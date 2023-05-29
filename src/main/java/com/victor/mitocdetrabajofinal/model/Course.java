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
    @Column
    private String names;
    @Column
    private String initials;
    @Column
    private boolean status;

}
