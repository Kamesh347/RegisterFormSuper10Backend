package com.example.springlearn.Repo;

import com.example.springlearn.Entity.RegisterForm;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RegisterFormRepository extends JpaRepository<RegisterForm, Integer> {

    List<RegisterForm> findBySenderNameIgnoreCase(String senderName);
}
