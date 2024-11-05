package com.nbu.CSCB869.api;

import com.nbu.CSCB869.model.Student;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;


public interface StudentApi {
    @RequestMapping(
            method = {RequestMethod.POST},
            value = {"/student"},
            produces = {"application/json"},
            consumes = {"application/json"}
    )
    ResponseEntity<Student> createStudent(@RequestBody Student s);

    @RequestMapping(
            method = {RequestMethod.GET},
            value = {"/student/{fn}"},
            produces = {"application/json"}
    )
    ResponseEntity<Student> getStudent(@PathVariable String fn);

    @RequestMapping(
            method = {RequestMethod.GET},
            value = {"/student/all"},
            produces = {"application/json"}
    )
    ResponseEntity<List<Student>> getAllStudents();

    @RequestMapping(
            method = {RequestMethod.DELETE},
            value = {"/student/{fn}"},
            produces = {"application/json"}
    )
    ResponseEntity<Void> deleteStudent(@PathVariable String fn);

    @RequestMapping(
            method = {RequestMethod.PUT},
            value = {"/student"},
            produces = {"application/json"}
    )
    ResponseEntity<Student> editStudent(@RequestBody Student s);
}
