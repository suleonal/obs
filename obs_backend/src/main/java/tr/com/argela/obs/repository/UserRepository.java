package tr.com.argela.obs.repository;

import java.util.List;

import javax.transaction.Transactional;

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
}
