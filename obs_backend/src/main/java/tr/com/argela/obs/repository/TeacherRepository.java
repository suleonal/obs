package tr.com.argela.obs.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tr.com.argela.obs.entity.Teacher;

@Repository
//Long
public interface TeacherRepository extends JpaRepository<Teacher,Long> {

 

}
