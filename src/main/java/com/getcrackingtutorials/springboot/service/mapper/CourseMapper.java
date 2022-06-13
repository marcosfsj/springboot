package com.getcrackingtutorials.springboot.service.mapper;

import com.getcrackingtutorials.springboot.dto.CourseDto;
import com.getcrackingtutorials.springboot.entity.Course;
import com.getcrackingtutorials.springboot.entity.Instructor;
import org.mapstruct.*;

import java.util.List;
// do not forget to run: mvn clean install
@Mapper
public interface CourseMapper extends DtoToEntityMapper<CourseDto, Course> {

    @Override
    @Mappings(
            @Mapping(source = "dto.instructorId", target="instructor")
    )
    Course dtoToEntity(CourseDto dto);

    default Instructor mapInstructorId(Long instructorId) {
        Instructor instructor = new Instructor();
        instructor.setId(instructorId);
        return instructor;
    }

    @Override
    @Mappings(
            @Mapping(source="entity.instructor", target = "instructorId")
    )
    CourseDto entityToDto(Course entity);

    default Long mapInstructor(Instructor instructor) {
        return instructor.getId();
    }

    @Override
    List<Course> dtoToEntity(List<CourseDto> dtoList);

    @Override
    List<CourseDto> entityToDto(List<Course> entities);

}