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
import tr.com.argela.obs.entity.Grade;
import tr.com.argela.obs.service.GradeService;
import tr.com.argela.obs.service.UserService;

@RestController
@RequestMapping("/grade")
public class GradeController {

    @Autowired
    private GradeService service;

    @Autowired
    private UserService userService;

    @PostMapping("/save")
    public ResponseEntity<Grade> save(@RequestBody Grade grade) {
        Grade savedGrade = service.save(grade);
        return new ResponseEntity<Grade>(savedGrade, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Grade>> getAll(@RequestHeader("token") String token) {
        try {
            userService.validateToken(token, RoleType.Teacher);
            List<Grade> allGrades = service.getAll();
            return new ResponseEntity<List<Grade>>(allGrades, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<List<Grade>>(new ArrayList(), HttpStatus.UNAUTHORIZED);
        }
    }

    @GetMapping("{id}")
    public ResponseEntity findById(@RequestHeader("token") String token, @PathVariable("id") Long id) {
        try {
            userService.validateToken(token, RoleType.Teacher);
            Grade grade = service.findById(id);
            return new ResponseEntity<Grade>(grade, HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("you are not authorized");
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteById(@RequestHeader("token") String token, @PathVariable("id") Long id) {
        try {
            userService.validateToken(token, RoleType.Teacher);
            service.deleteById(id);
            return new ResponseEntity<Void>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }

    @PutMapping("/value/{lectureId}/{studentId}/{value}")
    public ResponseEntity<Grade> value(@RequestHeader("token") String token, @PathVariable("lectureId") long lectureId,
            @PathVariable("studentId") long studentId, @PathVariable("value") int value) {
        try {
            userService.validateToken(token, RoleType.Student);
            service.value(lectureId, studentId, value);
            return new ResponseEntity<Grade>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }

    @GetMapping("/student/{studentId}")
    public ResponseEntity<List<Grade>> getGradeStudentById(@RequestHeader("token") String token,
            @PathVariable("studentId") long studentId) {
        try {
            userService.validateToken(token, RoleType.Student);
            List<Grade> students = service.getGradesByStudentId(studentId);
            return new ResponseEntity<List<Grade>>(students, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<List<Grade>>(new ArrayList(), HttpStatus.UNAUTHORIZED);
        }
    }

    @GetMapping("/lecture/{lectureId}")
    public ResponseEntity<List<Grade>> getGradeLectureById(@RequestHeader("token") String token,
            @PathVariable("lectureId") long lectureId) {
        try {
            userService.validateToken(token, RoleType.Teacher);
            List<Grade> lectures = service.getGradesByLectureId(lectureId);
            return new ResponseEntity<List<Grade>>(lectures, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<List<Grade>>(new ArrayList(), HttpStatus.UNAUTHORIZED);
        }
    }

    @GetMapping("/control/{lectureId}/{studentId}")
    public ResponseEntity<List<Grade>> getGradesByLectureStudentId(@RequestHeader("token") String token,
            @PathVariable("lectureId") long lectureId,
            @PathVariable("studentId") long studentId) {
        try {
            userService.validateToken(token, RoleType.Student);
            List<Grade> grades = service.getGradesByLectureStudentId(lectureId, studentId);
            return new ResponseEntity<List<Grade>>(grades, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<List<Grade>>(new ArrayList(), HttpStatus.UNAUTHORIZED);
        }
    }

}
