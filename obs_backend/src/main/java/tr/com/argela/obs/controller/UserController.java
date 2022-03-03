package tr.com.argela.obs.controller;

import java.util.List;

import javax.xml.registry.infomodel.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Util.GeneralUtil;
import tr.com.argela.obs.entity.UserSession;
import tr.com.argela.obs.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService service;

    @PutMapping("/login/{user}/{password}")
    public ResponseEntity<String> login(@PathVariable String user, @PathVariable String password) {
        try {
            String guid = service.login(user, password);
            return new ResponseEntity<String>(guid, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<String>(e.getMessage(),HttpStatus.UNAUTHORIZED);
        }
    }
    @DeleteMapping("/logout/{token}")
    public ResponseEntity<Void> logout(@PathVariable("token") String token) { 
        service.logout(token);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}