package com.example.webproject.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GroupByIdResponseDto {
    private int id;
    private String number;
    private List<StudentDto> students;
}
