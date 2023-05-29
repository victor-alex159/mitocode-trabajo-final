package com.victor.mitocdetrabajofinal.service.Impl;

import com.victor.mitocdetrabajofinal.model.Student;
import com.victor.mitocdetrabajofinal.repository.IGenericRepo;
import com.victor.mitocdetrabajofinal.repository.IStudentRepository;
import com.victor.mitocdetrabajofinal.service.IStudentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class StudentServiceImpl extends CRUDImpl<Student, Integer> implements IStudentService {

    private final IStudentRepository studentRepository;

    @Override
    protected IGenericRepo<Student, Integer> getRepo() {
        return studentRepository;
    }

    @Override
    public List<Student> getListStudentsByAge() {
        List<Student> listStudents = studentRepository.findAll();
        if(listStudents != null || !listStudents.isEmpty()) {
            List<Student> listResult = listStudents.stream()
                    .sorted(Comparator.comparing(Student::getAge).reversed())
                    .collect(Collectors.toList());
            return listResult;
        }
        return listStudents;
    }


}
