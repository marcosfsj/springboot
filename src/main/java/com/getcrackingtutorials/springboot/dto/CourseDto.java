package com.getcrackingtutorials.springboot.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CourseDto {

    private Long id;

    @NotEmpty(message = "Title is required!")
    @Length(min = 5, max = 15, message = "Title should be between 5 and 15 characters long!")
//    @Email
//    @Positive
//    @Negative
//    @Past
//    @PastOrPresent
//    @Future
//    @FutureOrPresent
    private String title;

    private Long instructorId;

    @Min(value = 10, message = "The number of available seats should be between 10 and 20!")
    @Max(value = 20, message = "The number of available seats should be between 10 and 20!")
    private Integer numberOfSeats;

}
