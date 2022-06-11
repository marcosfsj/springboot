package com.getcrackingtutorials.springboot.service.mapper;

import com.getcrackingtutorials.springboot.dto.InstructorDto;
import com.getcrackingtutorials.springboot.entity.Instructor;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(
        builder = @Builder(disableBuilder = true),
        uses = {CourseMapper.class}
)
public interface InstructorMapper extends DtoToEntityMapper<InstructorDto, Instructor> {

    @Override
    Instructor dtoToEntity(InstructorDto dto);

    @Override
    InstructorDto entityToDto(Instructor entity);

    @Override
    List<Instructor> dtoToEntity(List<InstructorDto> dtos);

    @Override
    List<InstructorDto> entityToDto(List<Instructor> entities);

}