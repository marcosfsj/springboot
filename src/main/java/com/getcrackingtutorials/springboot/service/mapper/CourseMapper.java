package com.getcrackingtutorials.springboot.service.mapper;

import com.getcrackingtutorials.springboot.dto.CourseDto;
import com.getcrackingtutorials.springboot.dto.InstructorDto;
import com.getcrackingtutorials.springboot.entity.Course;
import com.getcrackingtutorials.springboot.entity.Instructor;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper
public interface CourseMapper extends DtoToEntityMapper<CourseDto, Course> {

    @Override
    Course dtoToEntity(CourseDto dto);

    @Override
    CourseDto entityToDto(Course entity);

    @Override
    List<Course> dtoToEntity(List<CourseDto> dtos);

    @Override
    List<CourseDto> entityToDto(List<Course> entities);

}