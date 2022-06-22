package com.getcrackingtutorials.springboot.controller;

import com.getcrackingtutorials.springboot.mother.dto.InstructorDtoMother;
import com.getcrackingtutorials.springboot.mother.entity.InstructorMother;
import com.getcrackingtutorials.springboot.service.InstructorService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(InstructorController.class)
class InstructorControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private InstructorService instructorService;

    @Test
    void create() throws Exception {
        Mockito.when(instructorService.create(InstructorDtoMother.instructorDtoWithNoId())).thenReturn(InstructorDtoMother.instructorDto());
        mockMvc.perform(post("/api/v1/instructors")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{ \"firstName\": \"firstName\", \"lastName\": \"lastName\"} "))
                        .andExpect(status().isOk());
    }

    @Test
    void findById() throws Exception {
        Mockito.when(instructorService.findById(1L)).thenReturn(InstructorDtoMother.instructorDto());
        mockMvc.perform(get("/api/v1/instructors/1")
                        .contentType(MediaType.APPLICATION_JSON))
                        .andExpect(status().isOk())
                        .andExpect(jsonPath("$.firstName").value(InstructorDtoMother.instructorDto().getFirstName()));
    }

}