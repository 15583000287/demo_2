package cn.tedu.demo_1.repository;

import cn.tedu.demo_1.entity.Student;
import org.apache.catalina.ssi.SSIFsize;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import javax.swing.*;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentRepositoryTest {
    @Autowired
    private StudentRepository studentRepository;

    //分页查询
    @Test
    public void limitTest(){
        Sort sort = new Sort(Sort.Direction.DESC, "stuAge");
        //Pageable pageable = new PageRequest(1,10,sort);
        Pageable pageable = PageRequest.of(1,10,sort);
        Page<Student> pages = studentRepository.findAll(pageable);
        for(Student student: pages){
            System.out.println(student);
        }
    }

    @Test
    public void findByIdTest(){
        Student student = studentRepository.findById(16);
        System.out.println(student);
    }

    @Test
    public void findAllTest(){
        int page = 0;
        int size = 10;
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        //Pageable pageable = new PageRequest(page,size,sort);
        Pageable pageable = PageRequest.of(page,size,sort);
        Page<Student> pages = studentRepository.findAll(pageable);
        for(Student student: pages){
            System.out.println(student);
        }
    }

    @Test
    public void findbyIdLessThanTest(){
        List<Student> students = studentRepository.findByIdIsLessThan(20);
        for(Student student : students){
            System.out.println(student);
        }
    }

    @Test
    public void findidTest(){
        Student student = studentRepository.findStu("zhangsan","100");
        System.out.println(student);
    }

    @Test
    public void updateAgeByIdTest(){
        System.out.println(studentRepository.updateAgeById("101",16));
    }
}
