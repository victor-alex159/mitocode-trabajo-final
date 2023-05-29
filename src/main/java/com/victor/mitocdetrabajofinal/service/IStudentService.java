package com.victor.mitocdetrabajofinal.service;

import com.victor.mitocdetrabajofinal.model.Student;

import java.util.List;

public interface IStudentService extends ICRUD<Student, Integer> {

    List<Student> getListStudentsByAge();

}
