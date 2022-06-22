package com.getcrackingtutorials.springboot.service;

import com.getcrackingtutorials.springboot.dto.CourseDto;
import com.getcrackingtutorials.springboot.mother.entity.CourseMother;
import com.getcrackingtutorials.springboot.repository.CourseRepository;
import com.getcrackingtutorials.springboot.service.mapper.CourseMapper;
import org.junit.jupiter.api.*;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseServiceImplTest {

    @Autowired
    private CourseService sut;

    @MockBean
    private CourseRepository courseRepository;

    @Autowired
    private CourseMapper courseMapper;

    @Test
    @DisplayName("find all")
    void findAll() {
        Mockito.when(courseRepository.findAll()).thenReturn(List.of(CourseMother.course()));
        List<CourseDto> courses = sut.findAll();
        assertEquals(courses, courseMapper.entityToDto(List.of(CourseMother.course())));
    }

    @Test
    void findAllByInstructorId() {
        Mockito.when(courseRepository.findAllByInstructorId(1L)).thenReturn(List.of(CourseMother.course()));
        List<CourseDto> courses = sut.findAllByInstructorId(1L);
        assertEquals(courses, courseMapper.entityToDto(List.of(CourseMother.course())));
    }

    @Test
    void findAllByInstructorIdShouldReturnEmptyList() {
        Mockito.when(courseRepository.findAllByInstructorId(1L)).thenReturn(List.of(CourseMother.course()));
        List<CourseDto> courses = sut.findAllByInstructorId(2L);
        assertEquals(courses, Collections.emptyList());
    }

    @Test
    @Disabled
    void create() {
    }

    @Test
    void update() {
    }

    @Test
    void findById() {
    }

    @Test
    void deleteById() {
    }

    @Test
    void findByTitle() {
    }
}