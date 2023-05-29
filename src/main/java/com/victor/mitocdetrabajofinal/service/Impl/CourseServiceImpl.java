package com.victor.mitocdetrabajofinal.service.Impl;

import com.victor.mitocdetrabajofinal.model.Course;
import com.victor.mitocdetrabajofinal.model.Registration;
import com.victor.mitocdetrabajofinal.model.RegistrationDetail;
import com.victor.mitocdetrabajofinal.repository.ICourseRepository;
import com.victor.mitocdetrabajofinal.repository.IGenericRepo;
import com.victor.mitocdetrabajofinal.repository.IRegistrationRepository;
import com.victor.mitocdetrabajofinal.service.ICourseService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;


@Service
@Slf4j
@RequiredArgsConstructor
public class CourseServiceImpl extends CRUDImpl<Course, Integer> implements ICourseService {

    private final ICourseRepository courseRepository;
    private final IRegistrationRepository registrationRepository;

    @Override
    protected IGenericRepo<Course, Integer> getRepo() {
        return courseRepository;
    }


    @Override
    public Map<String, List<String>> courseStudents() throws Exception {
        Stream<Registration> registrationStream = registrationRepository.findAll().stream();
        Stream<List<RegistrationDetail>> registrationDetailStream = registrationStream.map(Registration::getDetails);
        Stream<RegistrationDetail> streamRegistrationDetail = registrationDetailStream.flatMap(Collection::stream);

        Map<String, List<String>> byCourseStudent = streamRegistrationDetail
                .collect(Collectors.groupingBy(d -> d.getCourse().getNames(),
                        Collectors.mapping(detail ->
                                (detail.getRegistration().getStudent().getNames() + " " + detail.getRegistration().getStudent().getLastName())
                                ,Collectors.toList())));

        return byCourseStudent;

    }
}
