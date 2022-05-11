package tr.com.argela.obs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

import tr.com.argela.obs.constant.RoleType;
import tr.com.argela.obs.entity.LoggedUser;
import tr.com.argela.obs.entity.Student;
import tr.com.argela.obs.entity.Teacher;
import tr.com.argela.obs.entity.User;
import tr.com.argela.obs.entity.UserSession;
import tr.com.argela.obs.repository.UserRepository;
import tr.com.argela.obs.repository.UserSessionRepository;
import tr.com.argela.obs.util.GeneralUtil;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserSessionRepository userSessionRepository;

    private static final long timeDuration = 1000 * 60 * 60;

    public String login(String username, String password) throws Exception {
        String md5 = GeneralUtil.getMD5Hash(password);
        List<User> users = userRepository.login(username, md5);

        if (users == null || users.isEmpty()) {
            throw new Exception("you are not authorized");

        } else {

            User user = users.get(0);

            String GUID = GeneralUtil.getGUID();

            UserSession userSession = new UserSession();
            userSession.setUser(new User(user.getId()));
            userSession.setSessionId(GUID);
            userSession.setLoginDate(new Date());

            userSessionRepository.save(userSession);

            return GUID;

        }
    }

    public void logout(String sessionId) {
        userSessionRepository.logoutSession(sessionId);
    }

    public void validateToken(String token, RoleType... roleTypes) throws Exception {

        List<UserSession> userSessions = userSessionRepository.validateToken(token);

        if (userSessions == null || userSessions.isEmpty()) {
            throw new Exception("you are not authorized");
        }
        UserSession userSession = userSessions.get(0);
        long loginDate = userSession.getLoginDate().getTime();
        long currentTime = new java.util.Date().getTime();

        if (currentTime - loginDate > timeDuration) {
            throw new Exception("timeout");
        }
        if (roleTypes.length == 1) {
            if (userSession.getUser().getRoleType() != roleTypes[0].getValue()) {
                throw new Exception("role type does not match");
            }
        }

    }

    public LoggedUser getLoggedUser(String token) throws Exception {
        List<UserSession> userSessions = userSessionRepository.validateToken(token);

        if (userSessions == null || userSessions.isEmpty()) {
            throw new Exception("you are not authorized");
        }
        UserSession userSession = userSessions.get(0);
        LoggedUser loggedUser = new LoggedUser();
        loggedUser.setId(userSession.getUser().getId());
        loggedUser.setRoleType(userSession.getUser().getRoleType());
        loggedUser.setEmail(userSession.getUser().getEmail());

        switch (userSession.getUser().getRoleType()) {

            case 1: {
                loggedUser.setEntityId(userSession.getUser().getStudent().getId());
                loggedUser.setEntityName(userSession.getUser().getStudent().getName());
                break;
            }
            case 2: {
                loggedUser.setEntityId(userSession.getUser().getTeacher().getId());
                loggedUser.setEntityName(userSession.getUser().getTeacher().getName());
                break;
            }
        }
        return loggedUser;
    }

}
