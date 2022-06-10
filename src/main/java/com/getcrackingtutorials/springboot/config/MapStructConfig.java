package com.getcrackingtutorials.springboot.config;

import com.getcrackingtutorials.springboot.dto.CourseDto;
import com.getcrackingtutorials.springboot.dto.InstructorDto;
import com.getcrackingtutorials.springboot.entity.Course;
import com.getcrackingtutorials.springboot.entity.Instructor;
import com.getcrackingtutorials.springboot.service.mapper.CourseMapper;
import com.getcrackingtutorials.springboot.service.mapper.DtoToEntityMapper;
import com.getcrackingtutorials.springboot.service.mapper.InstructorMapper;
import org.mapstruct.factory.Mappers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapStructConfig {

    @Bean
    public DtoToEntityMapper<InstructorDto, Instructor> instructorMapper() {
        return Mappers.getMapper(InstructorMapper.class);
    }

    @Bean
    public DtoToEntityMapper<CourseDto, Course> courseMapper() {
        return Mappers.getMapper(CourseMapper.class);
    }

}
