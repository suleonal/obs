package tr.com.argela.obs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tr.com.argela.obs.entity.Student;
import tr.com.argela.obs.repository.StudentRepository;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

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

    public void deleteLectureToStudent(long studentId, long lectureId){
        studentRepository.deleteLectureToStudent(studentId,lectureId);
    }

}
