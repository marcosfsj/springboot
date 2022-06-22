package com.getcrackingtutorials.springboot.mother.entity;

import com.getcrackingtutorials.springboot.entity.Course;

public class CourseMother {

    public static Course course() {
        return Course.builder()
                .id(1L)
                .title("course 1")
                .numberOfSeats(15)
                .instructor(InstructorMother.instructor())
                .build();
    }

}
