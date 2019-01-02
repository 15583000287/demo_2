package cn.tedu.demo_1.repository;

import cn.tedu.demo_1.entity.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentRepositoryTest {
    @Autowired
    private StudentRepository studentRepository;

    //分页查询
    @Test
    public void limitTest(){
        Sort sort = new Sort(Sort.Direction.DESC, "stuAge");
        Pageable pageable = new PageRequest(1,10,sort);
        Page<Student> pages = studentRepository.findAll(pageable);
        for(Student student: pages){
            System.out.println(student);
        }
    }

    @Test
    public void saveTest(){
        studentRepository.save(new Student("我","121"));

    }
}
