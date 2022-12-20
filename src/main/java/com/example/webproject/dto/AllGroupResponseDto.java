package com.example.webproject.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AllGroupResponseDto {
    private Integer id;
    private String number;
    private int quantityOfStudent;

}
