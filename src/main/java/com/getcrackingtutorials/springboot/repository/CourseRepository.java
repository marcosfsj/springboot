package com.getcrackingtutorials.springboot.repository;

import java.util.List;
import java.util.Optional;

import  com.getcrackingtutorials.springboot.entity.Course;
import org.springframework.data.jpa.repository.Query;

public interface CourseRepository extends BaseRepository<Course, Long> {
    List<Course> findAllByInstructorId(Long id);

    Optional<Course> findByTitle(String title);

    Optional<Course> findByTitleIgnoreCase(String title);

    @Query(value = "SELECT * FROM course WHERE title like %?1%", nativeQuery = true)
    Optional<Course> findWithCustomQuery(String title);

    @Query("SELECT c FROM Course c WHERE c.title like %?1")
    Optional<Course> findByTitleEndsWith(String endTitle);
}
