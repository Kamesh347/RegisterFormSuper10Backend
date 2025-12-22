package com.example.springlearn.Service;


import com.example.springlearn.Entity.RegisterForm;

import java.util.List;

public interface RegisterFormService {

    List<RegisterForm> getAllForms();

    RegisterForm getFormById(int id);

    List<RegisterForm> getFormBySenderName(String senderName);

    RegisterForm saveForm(RegisterForm form);

    void deleteFormById(int id);
}

