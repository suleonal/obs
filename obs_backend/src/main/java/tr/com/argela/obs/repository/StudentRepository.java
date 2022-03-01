package tr.com.argela.obs.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import tr.com.argela.obs.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
    @Modifying
    @Transactional
    @Query(value = "insert into student_lecture (lecture_id, student_id) VALUES (:lectureId, :studentId)", nativeQuery = true)
    public void value(@Param("lectureId") long lectureId, @Param("studentId") long studentId);
}