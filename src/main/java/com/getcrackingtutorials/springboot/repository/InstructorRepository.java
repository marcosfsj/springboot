package com.getcrackingtutorials.springboot.repository;

import com.getcrackingtutorials.springboot.entity.Instructor;

import java.util.Optional;

public interface InstructorRepository extends BaseRepository<Instructor, Long> {
    Optional<Instructor> findByFirstNameIgnoreCase(String FirstName);
}
