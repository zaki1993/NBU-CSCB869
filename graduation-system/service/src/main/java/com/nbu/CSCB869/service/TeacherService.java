package com.nbu.CSCB869.service;

import com.nbu.CSCB869.repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TeacherService {
    private final TeacherRepository teacherRepository;
}
