package tr.com.argela.obs.entity;

import java.sql.Date;

import javax.persistence.CascadeType;
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
    @Column(name = "id", unique = true, nullable = false)
    private long id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "email")
    private String email;

    @Column(name = "role_id")
    private int roleType;

    @Column(name = "last_login")
    private Date lastLogin;

    @OneToOne(mappedBy = "user")
    @JsonIgnore
    private Student student;

    @OneToOne(mappedBy = "user")
    @JsonIgnore
    private Teacher teacher;

    public User(long id) {
        this.id = id;
    }

    public User() {

    }
}