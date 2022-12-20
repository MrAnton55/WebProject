package com.example.webproject.service;

import com.example.webproject.entity.Group;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class GroupServiceImplTest {
    @Autowired
    GroupServiceImpl groupService;

    @Test
    void getAllGroup() {
        Group group = new Group();
        group.setId(1);
        group.setNumber("IT404");

        var allGroupResponseDto = groupService.getAllGroupResponseDto(group);
        Assertions.assertEquals(allGroupResponseDto.getId(), group.getId());
    }
}