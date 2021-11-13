package org.matemaster9.web.service;

import org.matemaster9.web.domain.Student;
import org.matemaster9.web.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

/**
 * @author matemaster9
 * @date 2021/11/13 21:28
 */
@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student getStudent(Long studentId) {
        Optional<Student> student = studentRepository.findById(studentId);
        if (!student.isPresent()) {
            throw new IllegalStateException("Student with id : " + studentId + " doesn't exists!");
        }
        return student.get();
    }

    public void addStudent(Student student) {
        Long id = student.getId();
        Optional<Student> optionalStudent = studentRepository.findById(id);
        if (optionalStudent.isPresent()) {
            throw new IllegalStateException("Student has exists!");
        }
        studentRepository.save(student);
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Transactional
    public void updateStudentInfo(Long studentId, Integer age, String name, String email) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new IllegalStateException("Student with id : " + studentId + " doesn't exists!"));
        if (age > 0 && !Objects.equals(age, student.getAge())) {
            student.setAge(age);
        }

        if (name != null &&
                name.length() > 0 &&
                !Objects.equals(name, student.getName())) {
            student.setName(name);
        }

        if (email != null && !Objects.equals(email, student.getEmail())) {
            student.setEmail(email);
        }
    }

    public void deleteStudent(Long studentId) {
        studentRepository.deleteById(studentId);
    }
}
