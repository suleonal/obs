package tr.com.argela.obs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import tr.com.argela.obs.entity.Lecture;

@Repository
public interface LectureRepository extends JpaRepository<Lecture, Long> {
    @Modifying
    @Transactional
    @Query(value = "update Lecture set teacher.id=:teacherId WHERE id=:lectureId")
    public void assignTeacherToLecture(@Param("teacherId") long teacherId ,@Param("lectureId") long lectureId);
}
