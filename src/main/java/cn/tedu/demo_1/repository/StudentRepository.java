package cn.tedu.demo_1.repository;

import cn.tedu.demo_1.entity.Student;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Entity;
import java.util.List;


@Repository  //可以省略
public interface StudentRepository extends JpaRepository<Student, Long> {
    void deleteAllByStuName(String StuName);
    Student findById(Integer id);
    //分页查询返回值Page<Student>
    Page<Student> findAll(Pageable pageable);

    List<Student> findByIdIsLessThan(Integer id);

    //自定义sql查询
    //@Transactional(timeout = 10)
    @Query(nativeQuery = true, value = "select id,stu_age,stu_name from t_student where stu_name = ?1 and stu_age=?2")
    Student findStu(String stuName,String age); //参数名与实体类属性一致

    //自定义修改操作
    @Transactional  //一定要添加事务 否则抛:TransactionRequiredException
    @Modifying  //删除，修改一定要加次注解
    @Query(nativeQuery = true, value = "update t_student set stu_age=?1 where id=?2")  //使用原生查询
    Integer updateAgeById(String stuAge, Integer id);
}
