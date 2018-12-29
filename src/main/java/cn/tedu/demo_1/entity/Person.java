package cn.tedu.demo_1.entity;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * DAO实体类
 */
@Entity
@Table(name = "t_person") //指定表名，不指定则默认，与实体类名一致
public class Person implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private long  id;
    @Column(nullable = false, unique = false)
    private String name;
    @Column(nullable = false)
    private String age;
    @Column(nullable = false)
    private String gender;
    @Transient //不被映射成列的字段
    private Date date;

    public Person() {
    }

    public Person(String name, String age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
