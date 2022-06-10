package com.getcrackingtutorials.springboot.service;

import java.util.List;

import com.getcrackingtutorials.springboot.dto.CourseDto;

public interface CourseService {

    public List<CourseDto> findAll();

    public List<CourseDto> findAllByInstructorId(Long instructorId);

    public CourseDto create(CourseDto courseDto);

    public CourseDto update(CourseDto courseDto, Long id);

    public  CourseDto findById(Long id);

    public void deleteById(Long id);

    public CourseDto findByTitle(String title);

}
