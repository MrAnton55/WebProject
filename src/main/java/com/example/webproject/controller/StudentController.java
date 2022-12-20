package com.example.webproject.controller;

import com.example.webproject.dto.AddStudentRequestDto;
import com.example.webproject.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/student")
@RequiredArgsConstructor
public class StudentController {
    private StudentService studentService;

    @PostMapping
    public void addStudent(@RequestBody AddStudentRequestDto studentGroupDto) {
        studentService.addStudent(studentGroupDto);
    }
}
