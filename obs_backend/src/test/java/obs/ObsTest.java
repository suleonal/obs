package obs;

import org.junit.jupiter.api.Assertions;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.sql.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import tr.com.argela.obs.ObsBackendApplication;
import tr.com.argela.obs.controller.LectureController;
import tr.com.argela.obs.controller.StudentController;
import tr.com.argela.obs.entity.Lecture;
import tr.com.argela.obs.entity.Student;
import tr.com.argela.obs.entity.User;
import tr.com.argela.obs.service.LectureService;
import tr.com.argela.obs.service.StudentService;
import tr.com.argela.obs.service.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK, classes = ObsBackendApplication.class)
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:application.properties")
public class ObsTest {

    @Autowired
    UserService userService;

    @Autowired
    StudentService studentService;

    @Autowired
    LectureService lectureService;

    static long dummyStudentId = 110522l;

    long lectureId = 1833010;

    @Test()
    public void test_login_success() {

        getToken();

    }

    @Test
    public void test_logging_failover() throws Exception {
        assertThrows(Exception.class, () -> {
            String user = userService.login("emine", "2");
        });
    }

    private String getToken() {
        assertDoesNotThrow(() -> {
            String token = userService.login("nebi", "1");
            assert token != null;
            return token;
        });
        return null;
    }

    @Test()
    public void test_studentNew() {
        User user = new User();
        user.setUsername("dummy");
        user.setPassword("c4ca4238a0b923820dcc509a6f75849b");
        user.setEmail("dummy.com");
        user.setRoleType(1);

        Student student = new Student();
        student.setId(110522l);
        student.setName("dummy");
        student.setTel(000051);
        student.setAdress("dummy51");
        student.setUser(user);

        Student savedStudent = studentService.save(student);
        assert savedStudent.getId() != null;

    }

    @Test()
    public void test_listStudents() {
        List<Student> students = (List<Student>) studentService.getAll();
        assert students != null && !students.isEmpty();
    }

    @Test()
    public void test_findByStudentId() {
        System.out.println("öğrenci id:" + dummyStudentId);
        Student student = studentService.findById(dummyStudentId);
        assert student != null && student.getName().equals("dummy") && student.getUser().getUsername().equals("dummy");
    }

    @Test()
    public void test_deleteByStudentId() {

        studentService.deleteById(dummyStudentId);
        Student student = studentService.findById(dummyStudentId);
        assert student == null;

    }

    @Test()
    public void test_saveLecture() {
        Lecture lecture = new Lecture();
        lecture.setId(lectureId);
        lecture.setName("JAVA_101");

        Lecture savedLecture = lectureService.save(lecture);
        assert savedLecture.getId() != null;
    }

    @Test()
    public void test_findByLectureId() {
        System.out.println("Ders id:" + lectureId);
        Lecture lecture = lectureService.findById(lectureId);
        assert lecture != null && lecture.getName().equals("JAVA_101");
    }

    @Test()
    public void test_addLectureToStudent() {
        Student student = studentService.findById(dummyStudentId);
        Lecture lecture = lectureService.findById(lectureId);
        studentService.addLectureToStudent(lectureId, dummyStudentId);
    }

}
