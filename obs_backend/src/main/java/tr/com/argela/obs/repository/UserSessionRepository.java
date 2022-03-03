package tr.com.argela.obs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import tr.com.argela.obs.entity.UserSession;

public interface UserSessionRepository extends JpaRepository<UserSession, Long> {
  
    @Modifying
    @Transactional
    @Query(value = "delete from user_session where session_id = :sessionId", nativeQuery = true)
    public void logoutSession(@Param("sessionId") String sessionId);
}
