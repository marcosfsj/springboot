package com.getcrackingtutorials.springboot.repository;

import com.getcrackingtutorials.springboot.entity.Instructor;
import com.getcrackingtutorials.springboot.mother.entity.InstructorMother;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class InstructorRepositoryTest {

    @Autowired
    private InstructorRepository sut;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    void shouldFindAll() {
        Instructor instructor = InstructorMother.instructorWithNoId();
        entityManager.persist(instructor);
        List<Instructor> instructors = sut.findAll();
        assertEquals(instructors, List.of(instructor));
    }
}