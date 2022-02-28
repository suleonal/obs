package tr.com.argela.obs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import tr.com.argela.obs.entity.Teacher;
import tr.com.argela.obs.repository.TeacherRepository;

@Service

public class TeacherService {

    @Autowired
    private TeacherRepository teacherRepository;

    public List<Teacher> getAll() {
        return teacherRepository.findAll();
    }

    public Teacher save(Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    public Teacher findById(long id) {
        return teacherRepository.findById(id).get();
    }

    public void deleteById(long id) {
        teacherRepository.deleteById(id);
    }

}

