package com.getcrackingtutorials.springboot.mother.entity;

import com.getcrackingtutorials.springboot.entity.Instructor;

public class InstructorMother {

    public static Instructor instructor() {
        return Instructor.builder()
                .id(1L)
                .firstName("Jon")
                .lastName("Doe")
                .build();
    }

    public static Instructor instructorWithNoId() {
        return Instructor.builder()
                .id(null)
                .firstName("Jon")
                .lastName("Doe")
                .build();
    }

}
