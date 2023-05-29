package com.victor.mitocdetrabajofinal.controller;

import com.victor.mitocdetrabajofinal.model.Registration;
import com.victor.mitocdetrabajofinal.service.IRegistrationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/registration")
@Slf4j
@RequiredArgsConstructor
public class RegistrationController {

    private final IRegistrationService registrationService;

    @PostMapping("/create")
    public ResponseEntity<Registration> saveRegistration(@Valid @RequestBody Registration registration) {
        Registration registrationSave = registrationService.saveRegistration(registration);
        return new ResponseEntity<>(registrationSave, HttpStatus.OK);
    }

    @PostMapping("/course-student")
    public ResponseEntity<List<Registration>> getListCourseStudent() throws Exception {
        List<Registration> listRegistration = registrationService.getRegistration();
        return new ResponseEntity<>(listRegistration, HttpStatus.OK);
    }

}
