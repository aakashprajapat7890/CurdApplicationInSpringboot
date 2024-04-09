package com.springboot.api.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="student_details")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;
    private Long roll_no;
    private String name;
    private Long contact;

}
