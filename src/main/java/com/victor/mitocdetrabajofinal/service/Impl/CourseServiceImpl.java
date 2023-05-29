package com.victor.mitocdetrabajofinal.service.Impl;

import com.victor.mitocdetrabajofinal.model.Course;
import com.victor.mitocdetrabajofinal.model.Registration;
import com.victor.mitocdetrabajofinal.model.RegistrationDetail;
import com.victor.mitocdetrabajofinal.model.Student;
import com.victor.mitocdetrabajofinal.repository.ICourseRepository;
import com.victor.mitocdetrabajofinal.repository.IGenericRepo;
import com.victor.mitocdetrabajofinal.repository.IRegistrationDetailRepository;
import com.victor.mitocdetrabajofinal.repository.IRegistrationRepository;
import com.victor.mitocdetrabajofinal.service.ICourseService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.summingDouble;


@Service
@Slf4j
@RequiredArgsConstructor
public class CourseServiceImpl extends CRUDImpl<Course, Integer> implements ICourseService {

    private final ICourseRepository courseRepository;
    private final IRegistrationRepository registrationRepository;
    private final IRegistrationDetailRepository registrationDetailRepository;

    @Override
    protected IGenericRepo<Course, Integer> getRepo() {
        return courseRepository;
    }


    @Override
    public Map<Course, List<Registration>> courseStudents() throws Exception {
        Stream<Registration> registrationStream = registrationRepository.findAll().stream();
        Stream<List<RegistrationDetail>> registrationDetailStream = registrationStream.map(Registration::getDetails);
        Stream<RegistrationDetail> streamRegistrationDetail = registrationDetailStream.flatMap(Collection::stream);
        Stream<Student> studentStream = streamRegistrationDetail.map(d -> d.getRegistration().getStudent());

        Stream<RegistrationDetail> registrationDetailStream1 = registrationDetailRepository.findAll().stream();
        Stream<Registration> registrationStream1 = registrationDetailStream1.map(RegistrationDetail::getRegistration);


        Map<Student, List<RegistrationDetail>> byCourse = streamRegistrationDetail
                .collect(groupingBy(d->d.getRegistration().getStudent()));

        Map<Course, List<Student>> byCourse2 = studentStream
                .collect(Collectors.groupingBy(RegistrationDetail::getCourse,
                        Collectors.mapping(Registration::getStudent, Collectors.toList()))));

        Map<Course, List<Student>> courseStudentMap = registrationStream
                .collect(Collectors.groupingBy(RegistrationDetail::getCourse,
                        Collectors.mapping(RegistrationDetail::getStudent, Collectors.toList())));

        return byCourse2;

    }
}
