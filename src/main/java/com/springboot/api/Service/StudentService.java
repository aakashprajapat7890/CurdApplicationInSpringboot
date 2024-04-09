package com.springboot.api.Service;

import com.springboot.api.entity.Student;
import com.springboot.api.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    private StudentRepo studentRepo;

    public void createStudent(Student student) {
        studentRepo.save(student);
    }

    public List<Student> getAllStudent() {
        return studentRepo.findAll();
    }

    public List<Student> getStudentOnSort(Integer pageNumber, Integer pageSize) {
        PageRequest pageRequest = PageRequest.of(pageNumber, pageSize);
        Page<Student> all = studentRepo.findAll(pageRequest);
        return all.stream().toList();
    }

    public Optional<Student> getStudentById(Long bid) {
        return studentRepo.findById(bid);

    }

    public void deleteStudent() {
        studentRepo.deleteAll();
    }

    public void deleteByid(Long id) {
        studentRepo.deleteById(id);
    }

    public void updateStudent(Student student, Long roll_no) {
        student.setRoll_no(roll_no);
        studentRepo.save(student);
    }


}
