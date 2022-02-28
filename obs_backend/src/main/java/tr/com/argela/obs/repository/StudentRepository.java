package tr.com.argela.obs.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import tr.com.argela.obs.entity.Lecture;
import tr.com.argela.obs.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

  
}