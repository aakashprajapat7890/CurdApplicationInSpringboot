package com.springboot.api.controller;


import com.springboot.api.Service.StudentService;
import com.springboot.api.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class StudentController
{
    @Autowired
    private StudentService studentService;

    @PostMapping("/save")
    public String createdStudent(@RequestBody Student student)
    {
        studentService.createStudent(student);
        return "Student Save Succefully";
    }
    @GetMapping("/student")
    public List<Student> getStudents()
    {
        return studentService.getAllStudent();
    }
    @GetMapping("/student/{pageNumber}/{pageSize}")
    public List<Student> getStudentsOnSort(@PathVariable("pageNumber") Integer pageNumber,@PathVariable("pageSize") Integer pageSize) {
        return studentService.getStudentOnSort(pageNumber,pageSize);
    }

    @GetMapping("/student/{id}")
    public Optional<Student> getStudent(@PathVariable("id") Long id )
    {
        return studentService.getStudentById(id);
    }
    @DeleteMapping("/delete")
    public  String deleteAll()
    {
        studentService.deleteStudent();
        return "Delete  All student here or Database";
    }
    @DeleteMapping("/delete/{bookId}")
     public  String deleteById(@PathVariable("bookId") Long bookId)
     {
         studentService.deleteByid(bookId);
         return "Delete a perticular Student";
     }
}
