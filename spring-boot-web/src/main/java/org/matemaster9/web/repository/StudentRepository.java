package org.matemaster9.web.repository;

import org.matemaster9.web.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author matemaster9
 * @date 2021/11/13 22:11
 */
public interface StudentRepository extends JpaRepository<Student, Long> {
}
