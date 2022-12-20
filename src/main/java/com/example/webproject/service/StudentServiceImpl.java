package com.example.webproject.service;

import com.example.webproject.dto.AddStudentRequestDto;
import com.example.webproject.entity.Group;
import com.example.webproject.entity.Student;
import com.example.webproject.repository.GroupRepository;
import com.example.webproject.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final GroupRepository groupRepository;
    private final StudentRepository studentRepository;

    @Override
    public void addStudent(AddStudentRequestDto studentGroupDto) {
        Group group = new Group();
        Student student = new Student();
        Optional<Group> myGroup = groupRepository.findById(group.getId());
        student.setGroup(myGroup.get());
        student.setName(studentGroupDto.getName());
        student.setId(studentGroupDto.getId());
        studentRepository.save(student);

    }
}
