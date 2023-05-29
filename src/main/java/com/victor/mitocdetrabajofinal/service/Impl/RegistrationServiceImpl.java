package com.victor.mitocdetrabajofinal.service.Impl;

import com.victor.mitocdetrabajofinal.model.Registration;
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

    @Override
    public List<Registration> getRegistration() {
        List<Registration> listRegistration = registrationRepository.findAll();
        if(listRegistration != null && !listRegistration.isEmpty()) {
            return listRegistration;
        }
        return null;
    }

    @Override
    public Registration saveRegistration(Registration registration) {
        return registrationRepository.save(registration);
    }
}
