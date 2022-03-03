package tr.com.argela.obs.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Data
@Getter
@Setter
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "email")
    private String email;

    @Column(name = "role_id")
    private int role_id;

    @Column(name = "last_login")
    private String last_login;

    @JsonIgnore
    @OneToOne(mappedBy = "user")
    private Student student;

    @JsonIgnore
    @OneToOne(mappedBy = "user")
    private Teacher teacher;

    @JsonIgnore
    @OneToOne(mappedBy = "user")
    private UserSession user_session;

}