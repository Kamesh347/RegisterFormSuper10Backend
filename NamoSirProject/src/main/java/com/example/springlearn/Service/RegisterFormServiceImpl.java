package com.example.springlearn.Service;


import com.example.springlearn.Entity.RegisterForm;
import com.example.springlearn.Repo.RegisterFormRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegisterFormServiceImpl implements RegisterFormService {

    private final RegisterFormRepository repository;

    public RegisterFormServiceImpl(RegisterFormRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<RegisterForm> getAllForms() {
        return repository.findAll();
    }

    @Override
    public RegisterForm getFormById(int id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Form not found with id: " + id));
    }

    @Override
    public List<RegisterForm> getFormBySenderName(String senderName) {
        return repository.findBySenderNameIgnoreCase(senderName);
    }

    @Override
    public RegisterForm saveForm(RegisterForm form) {
        return repository.save(form);
    }

    @Override
    public void deleteFormById(int id) {
        repository.deleteById(id);
    }
}
