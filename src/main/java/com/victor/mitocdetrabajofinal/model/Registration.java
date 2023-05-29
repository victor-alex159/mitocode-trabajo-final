package com.victor.mitocdetrabajofinal.model;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
public class Registration implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idRegistration;

    @Column(nullable = false)
    private LocalDateTime dateRegistration;

    @ManyToOne
    @JoinColumn(name = "id_student", nullable = false, foreignKey = @ForeignKey(name = "FK_REGISTRATION_STUDENT"))
    private Student student;

    @OneToMany(mappedBy = "registration", cascade = CascadeType.ALL)
    private List<RegistrationDetail> details;

    @Column(length = 1, nullable = false)
    private boolean status;

}
