package com.getcrackingtutorials.springboot.service;


import java.util.List;
import java.util.stream.Collectors;

import com.getcrackingtutorials.springboot.dto.CourseDto;
import com.getcrackingtutorials.springboot.exception.NotFoundException;
import com.getcrackingtutorials.springboot.service.mapper.CourseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.getcrackingtutorials.springboot.entity.Course;
import com.getcrackingtutorials.springboot.repository.CourseRepository;

@Service
public class CourseServiceImpl implements CourseService {

    private CourseRepository courseRepository;
    private CourseMapper courseMapper;

    @Autowired
    public CourseServiceImpl(CourseRepository courseRepository, CourseMapper courseMapper) {
        this.courseRepository = courseRepository;
        this.courseMapper = courseMapper;
    }

    @Transactional
    public List<CourseDto> findAll() {
        return courseRepository.findAll()
                .stream()
                .map(course -> courseMapper.entityToDto(course))
                .collect(Collectors.toList());
    }

    @Transactional
    public List<CourseDto> findAllByInstructorId(Long instructorId) {
        return courseRepository.findAllByInstructorId(instructorId)
                .stream()
                .map(course -> courseMapper.entityToDto(course))
                .collect(Collectors.toList());
    }

    @Transactional
    public CourseDto create(CourseDto courseDto) {
        Course course = courseRepository.save(courseMapper.dtoToEntity(courseDto));
        return courseMapper.entityToDto(course);
    }

    @Transactional
    public CourseDto update(CourseDto courseDto, Long id) {
        return courseRepository.findById(id).map(course -> {
            Course courseToSave = courseMapper.dtoToEntity(courseDto);
            courseToSave.setId(id);
            courseRepository.save(courseToSave);
            return courseMapper.entityToDto(courseToSave);
        }).orElseThrow(() -> new NotFoundException("Course id not found - " + id));
    }

    @Transactional
    public CourseDto findById(Long id) {
        return courseRepository.findById(id)
                .map(course -> courseMapper.entityToDto(course))
                .orElseThrow(() -> new NotFoundException("Course id not found - " + id));
    }

    @Transactional
    public void deleteById(Long id) {
        courseRepository.deleteById(id);
    }

    @Override
    public CourseDto findByTitle(String title) {
        return courseRepository.findByTitle(title)
                .map(course -> courseMapper.entityToDto(course))
                .orElseThrow(() -> new NotFoundException("Course with title " + title + " not found."));
    }

}
