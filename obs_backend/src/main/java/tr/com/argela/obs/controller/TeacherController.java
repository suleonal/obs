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
import tr.com.argela.obs.entity.Teacher;
import tr.com.argela.obs.service.TeacherService;

@RestController
@RequestMapping("/teacher")
public class TeacherController {

    @Autowired
    private TeacherService service;

    @PostMapping("/save")
    public ResponseEntity<Teacher> save(@RequestBody Teacher teacher) {
        Teacher savedTeacher= service.save(teacher);
        return new ResponseEntity<Teacher>(savedTeacher, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Teacher>> getAll() {
        List<Teacher> allTeachers = service.getAll();
        return new ResponseEntity<List<Teacher>>(allTeachers, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Teacher> findById(@PathVariable("id") Long id) {
        Teacher teacher= service.findById(id);
        return new ResponseEntity<Teacher>(teacher, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable("id") Long id) {
        service.deleteById(id);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

}
