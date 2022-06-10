package com.getcrackingtutorials.springboot.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InstructorDto {

    private Long id;

    @NotEmpty(message = "First name is required!")
    @Length(min = 5, max = 15, message = "First name should be between 7 and 10 characters long!")
    private String firstName;

    private List<CourseDto> courses;

}
