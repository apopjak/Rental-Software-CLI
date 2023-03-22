package org.example.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    //  SELECT * FROM student WHERE email = 'String email';
    Optional<Student> findStudentByEmail(String email);

    // SELECT * FROM student WHERE id = 'Long Id';
    Student findStudentById(Long Id);





    // Another way of doing that
//    @Query("SELECT s FROM Student s WHERE s.email= ?1")
}
