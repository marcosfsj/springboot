package com.getcrackingtutorials.springboot.controller;

import com.getcrackingtutorials.springboot.dto.InstructorDto;
import com.getcrackingtutorials.springboot.service.InstructorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/instructors")
public class InstructorController {

    @Autowired
    private InstructorService instructorService;

    private final Logger LOGGER = LoggerFactory.getLogger(InstructorController.class);
    // very simple, I will post a follow-up video to address logs in more details

    @GetMapping
    List<InstructorDto> findAll() {
        LOGGER.info("findAll method of InstructorController called!");
        return instructorService.findAll();
    }

    @GetMapping("/{id}")
    InstructorDto findById(@PathVariable Long id) {
        return instructorService.findById(id);
    }

    @PostMapping
    InstructorDto create(@Valid @RequestBody InstructorDto instructorDto) {
        return instructorService.create(instructorDto);
    }

    @PutMapping("/{id}")
    InstructorDto update(@Valid @RequestBody InstructorDto instructorDto, @PathVariable Long id) {
        return instructorService.update(instructorDto, id);
    }

    @DeleteMapping("/{id}")
    void deleteById(@PathVariable Long id) {
        instructorService.deleteById(id);
    }

    @GetMapping("/byFirstName/{firstName}")
    public InstructorDto findByFirstName(@PathVariable String firstName) {
        return instructorService.findByFirstName(firstName);
    }

}

