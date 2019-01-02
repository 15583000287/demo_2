package cn.tedu.demo_1.repository;

import cn.tedu.demo_1.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Spring Data JPA
 */
@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
    List<Person> findAll();
    Person findByName(String name);
}
