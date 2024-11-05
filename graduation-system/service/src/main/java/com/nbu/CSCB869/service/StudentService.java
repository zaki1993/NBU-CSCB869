package com.nbu.CSCB869.service;

import com.nbu.CSCB869.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;
}
