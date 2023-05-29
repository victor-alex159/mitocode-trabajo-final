package com.victor.mitocdetrabajofinal.dto;

import com.victor.mitocdetrabajofinal.model.RegistrationDetail;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class RegistrationDTO {

    private LocalDateTime dateRegistration;
    private Integer idStudent;
    private Integer idCourse;
    private boolean status;
    private String room;

}
