package cn.tedu.demo_1.entity;

import javax.persistence.*;

@Entity
@Table(name = "t_student")
public class Student {
    @Id
    @GeneratedValue
    private Integer id;
    @Column(nullable = false,unique = false, length = 20)
    private String stuName;
    @Column(nullable = false, length = 5)
    private String stuAge;

    public Student() {

    }

    public Student(String stuName, String stuAge) {
        this.stuName = stuName;
        this.stuAge = stuAge;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public String getStuAge() {
        return stuAge;
    }

    public void setStuAge(String stuAge) {
        this.stuAge = stuAge;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", stuName='" + stuName + '\'' +
                ", stuAge='" + stuAge + '\'' +
                '}';
    }


}
