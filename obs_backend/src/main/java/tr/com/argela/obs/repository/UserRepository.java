package tr.com.argela.obs.repository;

import java.util.List;

import javax.transaction.Transactional;

import tr.com.argela.obs.entity.LoggedUser;
import tr.com.argela.obs.entity.Student;
import tr.com.argela.obs.entity.Teacher;
import tr.com.argela.obs.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Long> {
    @Modifying
    @Transactional
    @Query(value = "Select u from User u WHERE u.username = :username and u.password = :password")
    public List<User> login(@Param("username") String username, @Param("password") String password);

    @Modifying
    @Transactional
    @Query(value = "select * from student where user_id = :userId", nativeQuery = true)
    public List<Student> getLoggedStudent(@Param("userId") int userId);

    @Modifying
    @Transactional
    @Query(value = "select * from teacher where user_id = :userId", nativeQuery = true)
    public List<Teacher> getLoggedTeacher(@Param("userId") int userId);

}
