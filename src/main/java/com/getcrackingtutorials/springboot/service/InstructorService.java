package com.getcrackingtutorials.springboot.service;

import com.getcrackingtutorials.springboot.dto.InstructorDto;

import java.util.List;

public interface InstructorService {

    List<InstructorDto> findAll();

    InstructorDto create(InstructorDto instructorDto);

    InstructorDto update(InstructorDto instructorDto, Long id);

    InstructorDto findById(Long id);

    void deleteById(Long id);

    InstructorDto findByFirstName(String firstName);

}
