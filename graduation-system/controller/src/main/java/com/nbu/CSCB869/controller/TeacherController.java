package com.nbu.CSCB869.controller;

import com.nbu.CSCB869.service.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TeacherController {
    private final TeacherService teacherService;
}
