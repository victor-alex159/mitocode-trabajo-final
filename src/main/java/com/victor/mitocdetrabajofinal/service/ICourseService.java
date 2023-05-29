package com.victor.mitocdetrabajofinal.service;


import com.victor.mitocdetrabajofinal.model.Course;
import com.victor.mitocdetrabajofinal.model.Registration;
import com.victor.mitocdetrabajofinal.model.RegistrationDetail;
import com.victor.mitocdetrabajofinal.model.Student;

import java.util.List;
import java.util.Map;

public interface ICourseService extends ICRUD<Course, Integer>  {

    Map<String, List<String>> courseStudents() throws Exception;

}
