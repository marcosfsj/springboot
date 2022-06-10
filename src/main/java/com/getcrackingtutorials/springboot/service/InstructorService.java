package com.getcrackingtutorials.springboot.service;

import com.getcrackingtutorials.springboot.dto.InstructorDto;

import java.util.List;

public interface InstructorService {

    public List<InstructorDto> findAll();

    public InstructorDto create(InstructorDto instructorDto);

    public InstructorDto update(InstructorDto instructorDto, Long id);

    public  InstructorDto findById(Long id);

    public void deleteById(Long id);

    public InstructorDto findByFirstName(String firstName);

}
