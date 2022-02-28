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
import tr.com.argela.obs.entity.Lecture;
import tr.com.argela.obs.service.LectureService;

@RestController
@RequestMapping("/lecture")
public class LectureController {

    @Autowired
    private LectureService service;

    @PostMapping("/save")
    public ResponseEntity<Lecture> save(@RequestBody Lecture lecture) {
        Lecture savedLecture = service.save(lecture);
        return new ResponseEntity<Lecture>(savedLecture, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Lecture>> getAll() {
        List<Lecture> allLectures = service.getAll();
        return new ResponseEntity<List<Lecture>>(allLectures, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Lecture> findById(@PathVariable("id") Long id) {
        Lecture lecture = service.findById(id);
        return new ResponseEntity<Lecture>(lecture, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable("id") Long id) {
        service.deleteById(id);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @PutMapping("/assign/{teacherId}/{lectureId}")
	public ResponseEntity<Void> assignTeacherToLecture(@PathVariable("teacherId") long teacherId , @PathVariable("lectureId") long lectureId){
		service.assignTeacherToLecture(teacherId, lectureId);
        return new ResponseEntity<Void>(HttpStatus.OK);
	}

}
