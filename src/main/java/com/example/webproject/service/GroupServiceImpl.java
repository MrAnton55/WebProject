package com.example.webproject.service;

import com.example.webproject.dto.AddGroupRequestDto;
import com.example.webproject.dto.AllGroupResponseDto;
import com.example.webproject.dto.GroupByIdResponseDto;
import com.example.webproject.dto.StudentDto;
import com.example.webproject.entity.Group;
import com.example.webproject.repository.GroupRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class GroupServiceImpl implements GroupService {
    private final GroupRepository groupRepository;

    @Override
    public void addGroup(AddGroupRequestDto addGroupRequestDto) {
        Group group = new Group();
        group.setNumber(addGroupRequestDto.getNumber());
        groupRepository.save(group);
    }

    @Override
    public List<AllGroupResponseDto> getAllGroup() {
        List<Group> all = groupRepository.findAll();
        log.debug("group finded {} ", all);

        List<AllGroupResponseDto> collect = Optional.ofNullable(all)
                .orElse(Collections.emptyList())
                .stream()
                .map(group -> {
                    return getAllGroupResponseDto(group);
                }).collect(Collectors.toList());
        return collect;
    }

    public AllGroupResponseDto getAllGroupResponseDto(Group group) {
        AllGroupResponseDto allGroupResponseDto = new AllGroupResponseDto();
        allGroupResponseDto.setId(group.getId());
        allGroupResponseDto.setNumber(group.getNumber());
        allGroupResponseDto.setQuantityOfStudent(Optional.ofNullable(group.getStudents())
                .orElse(Collections.emptyList())
                .size());
        return allGroupResponseDto;
    }

    @Override
    public GroupByIdResponseDto getGroupById(int id) {
        Optional<Group> byId = groupRepository.findById(id);
        List<StudentDto> collect = byId.map(Group::getStudents)
                .orElse(Collections.emptyList())
                .stream()
                .map(student -> {
                    StudentDto studentDto = new StudentDto();
                    studentDto.setName(student.getName());
                    studentDto.setId(student.getId());
                    studentDto.setLocalDate(student.getLocalDate());
                    return studentDto;
                }).collect(Collectors.toList());
        GroupByIdResponseDto groupByIdResponseDto = new GroupByIdResponseDto();
        groupByIdResponseDto.setStudents(collect);
        groupByIdResponseDto.setNumber(byId.get().getNumber());
        groupByIdResponseDto.setId(byId.get().getId());
        return groupByIdResponseDto;

    }

}
