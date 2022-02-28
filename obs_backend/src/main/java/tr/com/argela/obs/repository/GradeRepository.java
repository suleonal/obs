package tr.com.argela.obs.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import tr.com.argela.obs.entity.Grade;

public interface GradeRepository extends JpaRepository<Grade, Long> {
    @Modifying
    @Transactional
    @Query(value = "insert into grade (lecture_id, student_id, value) VALUES (:lectureId, :studentId, :value)", nativeQuery = true)
    public void value(@Param("lectureId") long lectureId, @Param("studentId") long studentId, int value);

    @Query(value = "select * from grade where student_id = :studentId", nativeQuery = true)
    public List<Grade> getGradesByStudentId(@Param("studentId") long studentId);

    @Query(value = "select * from grade where lecture_id = :lectureId", nativeQuery = true)
    public List<Grade> getGradesByLectureId(@Param("lectureId") long lectureId);

    @Query(value = "select * from grade where lecture_id = :lectureId and student_id = :studentId", nativeQuery = true)
    public List<Grade> getGradesByLectureStudentId(@Param("lectureId") long lectureId, @Param("studentId") long studentId);
}
