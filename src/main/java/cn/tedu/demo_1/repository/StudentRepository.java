package cn.tedu.demo_1.repository;

import cn.tedu.demo_1.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;


public interface StudentRepository extends JpaRepository<Student, Long> {
    void deleteAllByStuName(String StuName);

}
