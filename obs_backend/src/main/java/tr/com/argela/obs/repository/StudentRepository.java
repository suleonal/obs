package tr.com.argela.obs.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import tr.com.argela.obs.entity.Student;


public interface StudentRepository extends JpaRepository<Student,Long> {

}

