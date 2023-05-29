package com.victor.mitocdetrabajofinal.controller;

import com.victor.mitocdetrabajofinal.model.Course;
import com.victor.mitocdetrabajofinal.service.ICourseService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/course")
@Slf4j
@RequiredArgsConstructor
public class CourseController {

    private final ICourseService courseService;

    @PostMapping("/create")
    public ResponseEntity<Course> createCourse(@Valid @RequestBody Course course) throws Exception {
        Course courseSave = courseService.save(course);
        return new ResponseEntity<>(courseSave, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Course> updateCourse(@Valid @RequestBody Course course, @PathVariable("id") Integer id) throws Exception {
        Course courseSave = courseService.update(course, id);
        return new ResponseEntity<>(courseSave, HttpStatus.OK);
    }

    @GetMapping("/all-course")
    public ResponseEntity<List<Course>> readAllCourse() throws Exception {
        List<Course> listCourse = courseService.readAll();
        return new ResponseEntity<>(listCourse, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteCourse(@PathVariable("id") Integer id) throws Exception {
        courseService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping("/course-students")
    public ResponseEntity<Map<String, List<String>>> coursesStudent() throws Exception {
        return new ResponseEntity<>(courseService.courseStudents(), HttpStatus.OK);
    }

}
