package tr.com.argela.obs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tr.com.argela.obs.entity.Lecture;
import tr.com.argela.obs.entity.Student;
import tr.com.argela.obs.service.LectureService;
import tr.com.argela.obs.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService service;

    @Autowired
    private LectureService lectureService;

    @PostMapping("/save")
    public ResponseEntity<Student> save(@RequestBody Student student) {
        Student savedStudent = service.save(student);
        return new ResponseEntity<Student>(savedStudent, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Student>> getAll() {
        List<Student> allStudents = service.getAll();
        return new ResponseEntity<List<Student>>(allStudents, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Student> findById(@PathVariable("id") Long id) {
        Student student = service.findById(id);
        return new ResponseEntity<Student>(student, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable("id") Long id) {
        service.deleteById(id);
        return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
    }

    @GetMapping("/lectures/{studentId}")
    public ResponseEntity<List<Lecture>> getLecturesByStudentId(@PathVariable("studentId") long studentId) {
        List<Lecture> lectures = lectureService.getStudentLectures(studentId);
        return new ResponseEntity<List<Lecture>>(lectures,HttpStatus.OK);
    }

}
