package com.getcrackingtutorials.springboot.service.mapper;

import com.getcrackingtutorials.springboot.dto.CourseDto;
import com.getcrackingtutorials.springboot.entity.Course;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;
// do not forget to run: mvn clean install
@Mapper
public interface CourseMapper extends DtoToEntityMapper<CourseDto, Course> {

    @Override
    Course dtoToEntity(CourseDto dto);

    @Override
    @Mappings(
            @Mapping(target="instructorId", source = "entity.instructor.id")
    )
    CourseDto entityToDto(Course entity);

    @Override
    List<Course> dtoToEntity(List<CourseDto> dtos);

    @Override
    List<CourseDto> entityToDto(List<Course> entities);

}