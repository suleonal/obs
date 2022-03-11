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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import tr.com.argela.obs.constant.RoleType;
import tr.com.argela.obs.entity.Lecture;
import tr.com.argela.obs.entity.Teacher;
import tr.com.argela.obs.service.LectureService;
import tr.com.argela.obs.service.TeacherService;
import tr.com.argela.obs.service.UserService;

@RestController
@RequestMapping("/teacher")
public class TeacherController {

    @Autowired
    private TeacherService service;

    @Autowired
    private UserService userService;

    @Autowired
    private LectureService lectureService;

    @PostMapping("/save")
    public ResponseEntity<Teacher> save(@RequestBody Teacher teacher) {
        Teacher savedTeacher = service.save(teacher);
        return new ResponseEntity<Teacher>(savedTeacher, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Teacher>> getAll(@RequestHeader("token") String token) {
        try {
            userService.validateToken(token, RoleType.Teacher);
            List<Teacher> allTeachers = service.getAll();
            return new ResponseEntity<List<Teacher>>(allTeachers, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<List<Teacher>>(new ArrayList(), HttpStatus.UNAUTHORIZED);
        }
    }

    @GetMapping("{id}")
    public ResponseEntity findById(@RequestHeader("token") String token, @PathVariable("id") Long id) {
        try {
            userService.validateToken(token, RoleType.Teacher);
            return ResponseEntity.status(HttpStatus.OK).body(this.service.findById(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("you are not authorized");
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteById(@RequestHeader("token") String token, @PathVariable("id") Long id) {
        try {
            userService.validateToken(token, RoleType.Teacher);
            service.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }

    @GetMapping("/lectures/{teacherId}")
    public ResponseEntity<List<Lecture>> getLecturesByTeacherId(@RequestHeader("token") String token,
            @PathVariable("teacherId") int teacherId) {
        try {
            userService.validateToken(token, RoleType.Teacher);
            List<Lecture> lectures = lectureService.getTeacherLectures(teacherId);
            return new ResponseEntity<List<Lecture>>(lectures, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<List<Lecture>>(new ArrayList(), HttpStatus.UNAUTHORIZED);
        }
    }
}
