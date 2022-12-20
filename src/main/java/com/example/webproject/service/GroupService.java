package com.example.webproject.service;

import com.example.webproject.dto.AddGroupRequestDto;
import com.example.webproject.dto.AllGroupResponseDto;
import com.example.webproject.dto.GroupByIdResponseDto;

import java.util.List;

public interface GroupService {
    void addGroup(AddGroupRequestDto addGroupRequestDto);

    List<AllGroupResponseDto> getAllGroup();

    GroupByIdResponseDto getGroupById(int id);
}
