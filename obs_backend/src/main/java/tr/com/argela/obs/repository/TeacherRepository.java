package tr.com.argela.obs.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tr.com.argela.obs.entity.Lecture;
import tr.com.argela.obs.entity.Teacher;

@Repository
// Long
public interface TeacherRepository extends JpaRepository<Teacher, Long> {

}
