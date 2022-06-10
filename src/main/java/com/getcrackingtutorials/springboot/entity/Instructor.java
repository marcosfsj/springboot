package com.getcrackingtutorials.springboot.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

// the lombok plugin is needed for compilation of your project, but if you want your
// IDE to work with lombok also enable the lombok plugin (file -> settings -> plugins -> look for lombok)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder // builder design patters will be implemented
@Entity
public class Instructor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @OneToMany(
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER,
            orphanRemoval = true,
            mappedBy = "instructor")
    private List<Course> courses = new ArrayList<>();

}
