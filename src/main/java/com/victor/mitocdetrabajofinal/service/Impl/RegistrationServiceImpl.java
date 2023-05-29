package com.victor.mitocdetrabajofinal.service.Impl;

import com.victor.mitocdetrabajofinal.dto.RegistrationDTO;
import com.victor.mitocdetrabajofinal.model.Course;
import com.victor.mitocdetrabajofinal.model.Registration;
import com.victor.mitocdetrabajofinal.model.RegistrationDetail;
import com.victor.mitocdetrabajofinal.model.Student;
import com.victor.mitocdetrabajofinal.repository.IRegistrationDetailRepository;
import com.victor.mitocdetrabajofinal.repository.IRegistrationRepository;
import com.victor.mitocdetrabajofinal.service.IRegistrationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class RegistrationServiceImpl implements IRegistrationService {

    private final IRegistrationRepository registrationRepository;
    private final IRegistrationDetailRepository registrationDetailRepository;

    @Override
    public List<Registration> getRegistration() {
        List<Registration> listRegistration = registrationRepository.findAll();
        if(listRegistration != null && !listRegistration.isEmpty()) {
            return listRegistration;
        }
        return null;
    }


    /**
     * Registrar matricula
     * **/
    @Override
    public Registration saveRegistration(RegistrationDTO registrationDTO) {
        Registration registration = new Registration();
        RegistrationDetail registrationDetail = new RegistrationDetail();
        registration.setDateRegistration(registrationDTO.getDateRegistration());
        registration.setStudent(new Student());
        registration.getStudent().setId(registrationDTO.getIdStudent());
        registration.setStatus(registrationDTO.isStatus());
        Registration registrationSave = registrationRepository.save(registration);


        registrationDetail.setCourse(new Course());
        registrationDetail.getCourse().setId(registrationDTO.getIdCourse());
        registrationDetail.setRoom(registrationDetail.getRoom());
        registrationDetail.setRegistration(new Registration());
        registrationDetail.getRegistration().setIdRegistration(registrationSave.getIdRegistration());
        registrationDetailRepository.save(registrationDetail);
        return registrationSave;
    }
}
