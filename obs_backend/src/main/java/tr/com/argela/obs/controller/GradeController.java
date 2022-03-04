package tr.com.argela.obs.controller;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tr.com.argela.obs.entity.Grade;
import tr.com.argela.obs.service.GradeService;

@RestController
@RequestMapping("/grade")
public class GradeController {

    @Autowired
    private GradeService service;

    @PostMapping("/save")
    public ResponseEntity<Grade> save(@RequestBody Grade grade) {
        Grade savedGrade = service.save(grade);
        return new ResponseEntity<Grade>(savedGrade, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Grade>> getAll() {
        List<Grade> allGrades = service.getAll();
        return new ResponseEntity<List<Grade>>(allGrades, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Grade> findById(@PathVariable("id") Long id) {
        Grade grade = service.findById(id);
        return new ResponseEntity<Grade>(grade, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable("id") Long id) {
        service.deleteById(id);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @PutMapping("/value/{lectureId}/{studentId}/{value}")
    public ResponseEntity<Grade> value(@PathVariable("lectureId") long lectureId,
            @PathVariable("studentId") long studentId, @PathVariable("value") int value) {
        service.value(lectureId, studentId, value);
        return new ResponseEntity<Grade>(HttpStatus.OK);
    }

    @GetMapping("/student/{studentId}")
    public ResponseEntity<List<Grade>> getGradeStudentById(@PathVariable("studentId") long studentId) {
        List<Grade> students = service.getGradesByStudentId(studentId);
        return new ResponseEntity<List<Grade>>(students, HttpStatus.OK);
    }

    @GetMapping("/lecture/{lectureId}")
    public ResponseEntity<List<Grade>> getGradeLectureById(@PathVariable("lectureId") long lectureId) {
        List<Grade> lectures = service.getGradesByLectureId(lectureId);
        return new ResponseEntity<List<Grade>>(lectures, HttpStatus.OK);
    }

    @GetMapping("/control/{lectureId}/{studentId}")
    public ResponseEntity<List<Grade>> getGradesByLectureStudentId(@PathVariable("lectureId") long lectureId,
            @PathVariable("studentId") long studentId) {
        List<Grade> grades = service.getGradesByLectureStudentId(lectureId, studentId);
        return new ResponseEntity<List<Grade>>(grades, HttpStatus.OK);
    }

}
