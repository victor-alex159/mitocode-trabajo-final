package com.victor.mitocdetrabajofinal.controller;

import com.victor.mitocdetrabajofinal.model.Course;
import com.victor.mitocdetrabajofinal.model.Student;
import com.victor.mitocdetrabajofinal.service.IStudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
@Slf4j
@RequiredArgsConstructor
public class StudentController {

    private final IStudentService studentService;

    @PostMapping("/create")
    public ResponseEntity<Student> createStudent(@Valid @RequestBody Student student) throws Exception {
        Student studentSave = studentService.save(student);
        return new ResponseEntity<>(studentSave, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Student> updateStudent(@Valid @RequestBody Student student, @PathVariable("id") Integer id) throws Exception {
        Student studentSave = studentService.update(student, id);
        return new ResponseEntity<>(studentSave, HttpStatus.OK);
    }

    @GetMapping("/all-student")
    public ResponseEntity<List<Student>> readAllStudent() throws Exception {
        List<Student> listStudent = studentService.readAll();
        return new ResponseEntity<>(listStudent, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable("id") Integer id) throws Exception {
        studentService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping("/students-age")
    public ResponseEntity<List<Student>> getListStudentsByAge() throws Exception {
        List<Student> listStudentsByAge = studentService.getListStudentsByAge();
        return new ResponseEntity<>(listStudentsByAge, HttpStatus.OK);
    }


}
