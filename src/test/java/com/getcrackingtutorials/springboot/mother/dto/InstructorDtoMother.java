package com.getcrackingtutorials.springboot.mother.dto;

import com.getcrackingtutorials.springboot.dto.InstructorDto;

public class InstructorDtoMother {

    public static InstructorDto instructorDto() {
        return InstructorDto.builder()
                .id(1L)
                .firstName("Jon")
                .lastName("Doe")
                .build();
    }

    public static InstructorDto instructorDtoWithNoId() {
        return InstructorDto.builder()
                .id(null)
                .firstName("Jon")
                .lastName("Doe")
                .build();
    }

}
