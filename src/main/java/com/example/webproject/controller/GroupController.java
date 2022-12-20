package com.example.webproject.controller;

import com.example.webproject.dto.AddGroupRequestDto;
import com.example.webproject.dto.AllGroupResponseDto;
import com.example.webproject.dto.GroupByIdResponseDto;
import com.example.webproject.service.GroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/groups")
@RequiredArgsConstructor
public class GroupController {

    private final GroupService groupService;

    @PostMapping
    public void addGroup(@RequestBody AddGroupRequestDto addGroupRequestDto) {
        groupService.addGroup(addGroupRequestDto);
    }

    @GetMapping
    public List<AllGroupResponseDto> getAllGroup() {
        return groupService.getAllGroup();
    }

    @GetMapping(path = "/{id}")
    public GroupByIdResponseDto getGroupById(@PathVariable int id) {
        return groupService.getGroupById(id);
    }
}
