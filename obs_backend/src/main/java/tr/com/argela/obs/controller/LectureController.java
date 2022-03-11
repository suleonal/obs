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
import tr.com.argela.obs.service.LectureService;
import tr.com.argela.obs.service.UserService;

@RestController
@RequestMapping("/lecture")
public class LectureController {

    @Autowired
    private LectureService service;

    @Autowired
    private UserService userService;

    @PostMapping("/save")
    public ResponseEntity<Lecture> save(@RequestBody Lecture lecture) {
        Lecture savedLecture = service.save(lecture);
        return new ResponseEntity<Lecture>(savedLecture, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Lecture>> getAll(@RequestHeader("token") String token) {
        try {
            userService.validateToken(token, RoleType.Teacher);
            List<Lecture> allLectures = service.getAll();
            return new ResponseEntity<List<Lecture>>(allLectures, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<List<Lecture>>(new ArrayList(), HttpStatus.UNAUTHORIZED);
        }
    }

    @GetMapping("{id}")
    public ResponseEntity findById(@RequestHeader("token") String token, @PathVariable("id") Long id) {
        try {
            userService.validateToken(token, RoleType.Teacher);
            Lecture lecture = service.findById(id);
            return new ResponseEntity<Lecture>(lecture, HttpStatus.OK);
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

    @PutMapping("/assign/{teacherId}/{lectureId}")
    public ResponseEntity<Void> assignTeacherToLecture(@RequestHeader("token") String token,
            @PathVariable("teacherId") long teacherId,
            @PathVariable("lectureId") long lectureId) {
        try {
            userService.validateToken(token, RoleType.Teacher);
            service.assignTeacherToLecture(teacherId, lectureId);
            return new ResponseEntity<Void>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }

}
