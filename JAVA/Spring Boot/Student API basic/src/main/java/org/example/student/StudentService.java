package org.example.student;

import com.sun.jdi.request.DuplicateRequestException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Objects;
import java.util.Optional;


@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents() {
        // JPA returns the list of all students
        return studentRepository.findAll();

    }

    public void addNewStudent(Student student) {
        if (studentRepository.findStudentByEmail(student.getEmail()).isPresent()) {
            throw new DuplicateRequestException("Email %s1 already registered, Try again please".formatted(student.getEmail()));
        }
        studentRepository.save(student);
    }

    public void removeStudentById(Long Id) {

        if (!studentRepository.existsById(Id)) {
            throw new IllegalStateException("No such a student registered");
        }
        studentRepository.delete(studentRepository.findStudentById(Id));
    }

    @Transactional
    public void updateStudentById(Long Id,String name, String email) {
        Student student = studentRepository.findStudentById(Id);
        if (!studentRepository.existsById(Id)) {
            throw new IllegalStateException("No such a student registered");
        }
        if (name != null || name.length() > 0 && !Objects.equals(student.getName(), name)) {
            student.setName(name);
        }

        if (email != null || email.length() > 0 && !Objects.equals(student.getEmail(), email)) {
            if (studentRepository.findStudentByEmail(student.getEmail()).isPresent()) {
                throw new DuplicateRequestException("Email %s1 already registered, Try again please".formatted(student.getEmail()));
            }
            student.setEmail(email);
        }
        student.setName(name);
        student.setEmail(email);


    }
}
