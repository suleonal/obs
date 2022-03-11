package tr.com.argela.obs.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tr.com.argela.obs.constant.RoleType;
import tr.com.argela.obs.entity.Lecture;
import tr.com.argela.obs.entity.Student;
import tr.com.argela.obs.service.LectureService;
import tr.com.argela.obs.service.StudentService;
import tr.com.argela.obs.service.UserService;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService service;

    @Autowired
    private LectureService lectureService;

    @Autowired
    private UserService userService;

    @PostMapping("/save")
    public ResponseEntity<Student> save(@RequestBody Student student) {
        Student savedStudent = service.save(student);

        return new ResponseEntity<Student>(savedStudent, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Student>> getAll(@RequestHeader("token") String token) {
        try {
            userService.validateToken(token, RoleType.Student);
            List<Student> allStudents = service.getAll();
            return new ResponseEntity<List<Student>>(allStudents, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<List<Student>>(new ArrayList(), HttpStatus.UNAUTHORIZED);
        }
    }

    @GetMapping("{id}")
    public ResponseEntity findById(@RequestHeader("token") String token, @PathVariable("id") Long id) {
        try {
            userService.validateToken(token, RoleType.Student);
            return ResponseEntity.status(HttpStatus.OK).body(this.service.findById(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("you are not authorized");
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteById(@RequestHeader("token") String token, @PathVariable("id") Long id) {
        try {
            userService.validateToken(token, RoleType.Student);
            service.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }

    @GetMapping("/lectures/{studentId}")
    public ResponseEntity<List<Lecture>> getLecturesByStudentId(@RequestHeader("token") String token,
            @PathVariable("studentId") long studentId) {
        try {
            userService.validateToken(token, RoleType.Student);
            List<Lecture> lectures = lectureService.getStudentLectures(studentId);
            return new ResponseEntity<List<Lecture>>(lectures, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<List<Lecture>>(new ArrayList(), HttpStatus.UNAUTHORIZED);
        }
    }

    @PutMapping("/add/{lectureId}/{studentId}")
    public ResponseEntity<Void> addLectureToStudent(@RequestHeader("token") String token,
            @PathVariable("lectureId") long lectureId,
            @PathVariable("studentId") long studentId) {
        try {
            userService.validateToken(token, RoleType.Student);
            service.addLectureToStudent(lectureId, studentId);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }

    @DeleteMapping("/deleteLecture/{studentId}/{lectureId}")
    public ResponseEntity<Void> deleteLectureToStudent(@RequestHeader("token") String token,
            @PathVariable("studentId") long studentId,
            @PathVariable("lectureId") long lectureId) {
        try {
            userService.validateToken(token, RoleType.Student);
            service.deleteLectureToStudent(studentId, lectureId);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }

}
