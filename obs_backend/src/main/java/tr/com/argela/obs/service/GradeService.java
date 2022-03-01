package tr.com.argela.obs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tr.com.argela.obs.entity.Grade;

import tr.com.argela.obs.repository.GradeRepository;

@Service
public class GradeService {

    @Autowired
    private GradeRepository gradeRepository;

    public List<Grade> getAll() {
        return gradeRepository.findAll();
    }

    public Grade save(Grade grade) {
        return gradeRepository.save(grade);
    }

    public Grade findById(long id) {
        return gradeRepository.findById(id).get();
    }

    public void deleteById(long id) {
        gradeRepository.deleteById(id);
    }

    public void value(long lectureId, long studentId, int value) {

        List<Grade> grades = getGradesByLectureStudentId(lectureId, studentId);
        if (grades == null || grades.isEmpty()) {
            gradeRepository.value(lectureId, studentId, value);
        } else {
            Grade grade = grades.get(0);
            grade.setValue(value);
            save(grade);
        }
    }

    public List<Grade> getGradesByStudentId(long studentId) {
        return gradeRepository.getGradesByStudentId(studentId);
    }

    public List<Grade> getGradesByLectureId(long lectureId) {
        return gradeRepository.getGradesByLectureId(lectureId);
    }

    public List<Grade> getGradesByLectureStudentId(long lectureId, long studentId) {
        return gradeRepository.getGradesByLectureStudentId(lectureId, studentId);
    }

}
