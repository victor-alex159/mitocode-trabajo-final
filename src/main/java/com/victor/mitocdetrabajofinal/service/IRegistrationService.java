package com.victor.mitocdetrabajofinal.service;

import com.victor.mitocdetrabajofinal.model.Registration;
import com.victor.mitocdetrabajofinal.model.RegistrationDetail;

import java.util.List;

public interface IRegistrationService {

    List<Registration> getRegistration();
    Registration saveRegistration(Registration registration);

}
