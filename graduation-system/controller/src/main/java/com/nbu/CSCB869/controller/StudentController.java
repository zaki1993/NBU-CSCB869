package com.nbu.CSCB869.controller;

import com.nbu.CSCB869.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;
}
