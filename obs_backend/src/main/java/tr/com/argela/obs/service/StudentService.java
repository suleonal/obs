package tr.com.argela.obs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tr.com.argela.obs.entity.Student;
import tr.com.argela.obs.entity.UserSession;
import tr.com.argela.obs.repository.StudentRepository;
import tr.com.argela.obs.repository.UserSessionRepository;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private UserSessionRepository user_session_repo;

    public List<Student> getAll() {
        return studentRepository.findAll();
    }

    public Student save(Student student) {
        return studentRepository.save(student);
    }

    public Student findById(Long id) {
        return studentRepository.findById(id).get();
    }

    public void deleteById(Long id) {
        studentRepository.deleteById(id);
    }

    public void addLectureToStudent(long lectureId, long studentId) {
        studentRepository.addLectureToStudent(lectureId, studentId);
    }

    public void deleteLectureToStudent(long studentId, long lectureId) {
        studentRepository.deleteLectureToStudent(studentId, lectureId);
    }

    public List<Student> getStudentsByLectureId(long lectureId) {
        return studentRepository.getStudentsByLectureId(lectureId);
    }

}
