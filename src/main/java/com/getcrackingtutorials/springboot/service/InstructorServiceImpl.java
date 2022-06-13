package com.getcrackingtutorials.springboot.service;

import com.getcrackingtutorials.springboot.dto.InstructorDto;
import com.getcrackingtutorials.springboot.entity.Instructor;
import com.getcrackingtutorials.springboot.exception.NotFoundException;
import com.getcrackingtutorials.springboot.repository.InstructorRepository;
import com.getcrackingtutorials.springboot.service.mapper.DtoToEntityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class InstructorServiceImpl implements InstructorService {

    private final InstructorRepository instructorRepository;
    private final DtoToEntityMapper<InstructorDto, Instructor> instructorMapper;

    @Autowired
    public InstructorServiceImpl(InstructorRepository instructorRepository, DtoToEntityMapper<InstructorDto, Instructor> instructorMapper) {
        this.instructorRepository = instructorRepository;
        this.instructorMapper = instructorMapper;
    }

    @Transactional
    public List<InstructorDto> findAll() {
        return instructorRepository.findAll()
                .stream()
                .map(instructorMapper::entityToDto)
                .collect(Collectors.toList());
        // return new InstructorDto(instructor.getId(), instructor.getFirstName()); // a set for each property
    }

    @Transactional
    public InstructorDto create(InstructorDto instructorDto) {
        Instructor instructor = instructorRepository.save(instructorMapper.dtoToEntity(instructorDto));
        return instructorMapper.entityToDto(instructor);
    }

    @Transactional
    public InstructorDto update(InstructorDto instructorDto, Long id) {
        return instructorRepository.findById(id).map(instructor -> {
            Instructor instructorToSave = instructorMapper.dtoToEntity(instructorDto);
            instructorToSave.setId(id);
            instructorRepository.save(instructorToSave);
            return instructorMapper.entityToDto(instructorToSave);
        }).orElseThrow(() -> new NotFoundException("Instructor id not found - " + id));
    }

    @Transactional
    public InstructorDto findById(Long id) {
        //Method reference
        return instructorRepository.findById(id)
                .map(instructorMapper::entityToDto)
                .orElseThrow(() -> new NotFoundException("Instructor id not found - " + id));
    }

    @Transactional
    public void deleteById(Long id) {
        instructorRepository.deleteById(id);
    }

    @Override
    public InstructorDto findByFirstName(String firstName) {
        return instructorRepository.findByFirstNameIgnoreCase(firstName)
                .map(instructorMapper::entityToDto)
                .orElseThrow(() -> new NotFoundException("Instructor with first name " + firstName + " not found."));
    }

}
