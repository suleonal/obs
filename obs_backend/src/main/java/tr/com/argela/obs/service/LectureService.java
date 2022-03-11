package tr.com.argela.obs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tr.com.argela.obs.entity.Lecture;
import tr.com.argela.obs.repository.LectureRepository;

@Service
public class LectureService {

	@Autowired
	private LectureRepository lectureRepository;

	public List<Lecture> getAll() {
		return lectureRepository.findAll();
	}

	public Lecture save(Lecture lecture) {
		return lectureRepository.save(lecture);
	}

	public Lecture findById(Long id) {
		return lectureRepository.findById(id).get();
	}

	public void deleteById(Long id) {
		lectureRepository.deleteById(id);
	}

	public void assignTeacherToLecture(long teacherId, long lectureId) {
		lectureRepository.assignTeacherToLecture(teacherId, lectureId);
	}

	public List<Lecture> getStudentLectures(long studentId) {
		return lectureRepository.getStudentLectures(studentId);
	}

	public List<Lecture> getTeacherLectures(int teacherId) {
		return lectureRepository.getTeacherLectures(teacherId);
	}
}
