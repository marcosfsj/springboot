package com.getcrackingtutorials.springboot.service;

import java.util.List;

import com.getcrackingtutorials.springboot.dto.CourseDto;

public interface CourseService {

    List<CourseDto> findAll();

    List<CourseDto> findAllByInstructorId(Long instructorId);

    CourseDto create(CourseDto courseDto);

    CourseDto update(CourseDto courseDto, Long id);

    CourseDto findById(Long id);

    void deleteById(Long id);

    CourseDto findByTitle(String title);

}
