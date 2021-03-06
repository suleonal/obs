package tr.com.argela.obs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import tr.com.argela.obs.entity.Lecture;

@Repository
public interface LectureRepository extends JpaRepository<Lecture, Long> {
    @Modifying
    @Transactional
    @Query(value = "update Lecture set teacher.id=:teacherId WHERE id=:lectureId")
    public void assignTeacherToLecture(@Param("teacherId") long teacherId, @Param("lectureId") long lectureId);

    @Query(value = "select l.* from student_lecture sl, lecture l where l.id = sl.lecture_id and sl.student_id = :studentId", nativeQuery = true)
    public List<Lecture> getStudentLectures(@Param("studentId") long studentId);

    @Query(value = "select * from lecture where teacher_id = :teacherId", nativeQuery = true)
    public List<Lecture> getTeacherLectures(@Param("teacherId") int teacherId);


}
