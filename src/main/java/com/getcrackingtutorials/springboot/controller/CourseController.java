package com.getcrackingtutorials.springboot.controller;

import java.util.List;

import com.getcrackingtutorials.springboot.dto.CourseDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.getcrackingtutorials.springboot.service.CourseService;

@RestController
@RequestMapping("/api/v1/courses")
// different methods to version your API to come
public class CourseController {

    @Autowired
    private CourseService courseService;

    private final Logger LOGGER = LoggerFactory.getLogger(CourseController.class);
    // very simple, I will post a follow-up video to address logs in more details

    @GetMapping
    List<CourseDto> findAll() {
        LOGGER.info("findAll method of CourseController called!");
        return courseService.findAll();
    }

    @GetMapping("/{id}")
    CourseDto findById(@PathVariable Long id) {
        return courseService.findById(id);
    }

    @PostMapping
    CourseDto create(@RequestBody CourseDto course) {
        return courseService.create(course);
    }

    @PutMapping("/{id}")
    CourseDto update(@RequestBody CourseDto updatedCourse, @PathVariable Long id) {
        return courseService.update(updatedCourse, id);
    }

    @DeleteMapping("/{id}")
    void deleteById(@PathVariable Long id) {
        courseService.deleteById(id);
    }

    @GetMapping("/byTitle/{title}")
    public CourseDto findByTitle(@PathVariable String title) {
        return courseService.findByTitle(title);
    }

}

